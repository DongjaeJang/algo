package boj_self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ19236 {
	public static class Fish implements Comparable<Fish>, Cloneable{
		int index;
		int x;
		int y;
		int direction;
		
		public Fish (int index, int x, int y, int direction) {
			this.index = index;
			this.x = x;
			this.y = y;
			this.direction = direction;
		}
		
		
		public int compareTo (Fish o) {
			return this.index - o.index;
		}
		
		public Fish clone() {
			Object obj = null;
			try {
				obj = super.clone();
			} catch (CloneNotSupportedException e){
				e.printStackTrace();
			}
			return (Fish) obj;
		}
	}
	
	public static class Shark extends Fish implements Cloneable{
		int count;
		
		public Shark(int index, int x, int y, int direction) {
			super(index, x, y, direction);
			this.count = 0;
		}
		
		public void eat(int[][] board, List<Fish> fishList, int index) {
			board[this.x][this.y] = 0;
			Fish fish = fishList.get(index);
			
			this.x = fish.x;
			this.y = fish.y;
			this.direction = fish.direction;
			this.count += fish.index;
			
			board[this.x][this.y] = this.index;
			
			fishList.remove(index);
		}
		
		public Shark clone() {
			return (Shark)super.clone();
		}
	}
	
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
	
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] board = new int[4][4];	// 위치마다 물고기 번호 표시
		List<Fish> fishList = new ArrayList<Fish>();	// 물고기 번호, 위치, 방향
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int idx = Integer.parseInt(st.nextToken());
				int direct = Integer.parseInt(st.nextToken()) - 1;
				
				fishList.add(new Fish(idx, i, j, direct));
				board[i][j] = idx;
			}
		}
		
		fishList.sort(null);
		
		result = 0;
		// 상어 출발
		int target = findFish(fishList, board[0][0]);
		Shark shark = new Shark(17, 0, 0, fishList.get(target).direction);
		shark.eat(board, fishList, target);
		
		game(board, fishList, shark);
		
		System.out.println(result);
	}
	
	public static void game(int[][] board, List<Fish> fishList, Shark shark) {
		moveFish(board, fishList);
		List<Integer> targetList = nextFishList(board, fishList, shark);
		
		if (targetList.size() == 0) {
			result = Math.max(result, shark.count);
			return;
		}
		
		for (int i = 0; i < targetList.size(); i++) {
			int[][] copyBoard = new int[4][4];
			List<Fish> copyFishList = new ArrayList<>();
			Shark copyShark = shark.clone();
			
			for (Fish f : fishList) copyFishList.add(f.clone());
			for (int j = 0; j < 4; j++) copyBoard[j] = Arrays.copyOf(board[j], 4);
			
			int nextTarget = findFish(copyFishList, targetList.get(i));
			
			copyShark.eat(copyBoard, copyFishList, nextTarget);
			game(copyBoard, copyFishList, copyShark);
		}
	}
	
	
	public static void moveFish(int[][] board, List<Fish> fishList) {
		for (int i = 0; i < fishList.size(); i++) {
			Fish current = fishList.get(i);
			
			for (int d = 0; d < 8; d++) {
				int nextD = current.direction + d;
				if (nextD >= 8) nextD -= 8;
				
				int nextX = current.x + dx[nextD];
				int nextY = current.y + dy[nextD];
				
				if (outOfRange(nextX, nextY) || board[nextX][nextY] == 17) continue;
				if (board[nextX][nextY] == 0) {
					board[current.x][current.y] = 0;
					
					current.x = nextX;
					current.y = nextY;
					current.direction = nextD;
					board[nextX][nextY] = current.index;
					
					fishList.set(i, current);
					break;
				} else {
					int target = board[nextX][nextY];
					int targetIdx = findFish(fishList, target);
					
					if (targetIdx == -1) continue;
					Fish targetFish = fishList.get(targetIdx);

					int tempIdx = current.index;
					int tempX = current.x;
					int tempY = current.y;
					
					board[current.x][current.y] = targetFish.index;
					current.x = targetFish.x;
					current.y = targetFish.y;
					current.direction = nextD;
					
					board[targetFish.x][targetFish.y] = tempIdx;
					targetFish.x = tempX;
					targetFish.y = tempY;
					
					fishList.set(i, current);
					fishList.set(targetIdx, targetFish);
					break;
				}
			}
		}
	}
	
	public static int findFish(List<Fish> fishList, int index) {
		for (int i = 0; i < fishList.size(); i++) {
			if (fishList.get(i).index == index) return i;
		}
		return -1;
	}
	
	public static List<Integer> nextFishList(int[][] board, List<Fish> fishList, Shark shark) {
		List<Integer> tempList = new ArrayList<>();
		
		int nextX = shark.x;
		int nextY = shark.y;
		while (true) {
			nextX += dx[shark.direction];
			nextY += dy[shark.direction];
			
			if (outOfRange(nextX, nextY)) return tempList;
			if (board[nextX][nextY] != 0) tempList.add(board[nextX][nextY]);
		}
	}
	
	public static boolean outOfRange(int x, int y) {
		if (x < 0 || y < 0 || x == 4 || y == 4) return true;
		return false;
	}
}
