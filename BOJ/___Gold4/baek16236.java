package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Shark {
		int x;
		int y;
		int size;
		int count;
		
		public Shark(int x, int y) {
			this.x = x;
			this.y = y;
			this.size = 2;
			this.count = 0;
		}
	}
	
	static class Fish implements Comparable<Fish>{
		int x;
		int y;
		int size;
		
		public Fish(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}
		// 사이즈가 작고, 위쪽에 있고, 왼쪽에 있는 순으로 정렬
		public int compareTo(Fish o) {
			if (this.size == o.size) {
				if (this.x == o.x) {
					return this.y - o.y;
				}
				return this.x - o.x;
			}
			return this.size - o.size;
		}
	}
	
	static int second;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] board = new int[N][N];
		
		Shark shark = null;
		List<Fish> fishes = new ArrayList<>();	// 물고기 정보
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 9) shark = new Shark(i, j);	// 상어 업데이트
				else if (board[i][j] > 0 && board[i][j] < 7) fishes.add(new Fish(i, j, board[i][j]));	// 물고기 업데이트
			}
		}
		
		fishes.sort(null);	// 물고기 정렬
		
		second = 0;
		
		while (true) {
			int[][] distanceBoard = updateDistance(board, N, shark);	// 거리 정보 갱신
			
			if (callMother(board, distanceBoard, shark)) break;	// 먹을 수 있는 물고기가 없으면 탈출
			eatFish(board, distanceBoard, shark, fishes);	// 물고기 먹기
		}
		
		System.out.println(second);
	}
	
	// 가까운 물고기 찾아서 먹기
	private static void eatFish (int[][] board, int[][] distanceBoard, Shark shark, List<Fish> fishes) {
		int minDistance = Integer.MAX_VALUE;
		int index = -1;
		
		Fish targetFish = null;	// 타겟 저장할 공간
		
		for (int i = 0; i < fishes.size(); i++) {
			Fish current = fishes.get(i);
			if (current.size >= shark.size) break;
			
			if (canEat(board, distanceBoard, shark, current.x, current.y)) {
				if (minDistance > distanceBoard[current.x][current.y]) {	// 거리가 더 짧을 때는 바로 업데이트
					minDistance = distanceBoard[current.x][current.y];
					index = i;
					targetFish = fishes.get(i);
				} else if (minDistance == distanceBoard[current.x][current.y]) {	// 같을 때는 체크
					if (targetFish.x > current.x || (targetFish.x == current.x && targetFish.y > current.y)) {
						index = i;
						targetFish = fishes.get(i);
					}
				}
			}
		}
		
		fishes.remove(index);	// 물고기 목록에서 삭제
		
		board[shark.x][shark.y] = 0;
		board[targetFish.x][targetFish.y] = 9;	// 상어 자리로 대체
		
		shark.x = targetFish.x;	// 상어 자리 물고기 자리로 바꾸고
		shark.y = targetFish.y;
		second += minDistance - 1;	// 시간 업데이트

		shark.count++;	// 상어 카운트 올리고 사이즈 갱신
		if (shark.count == shark.size) {
			shark.size++;
			shark.count = 0;
		}
	}
	
	// 먹을 수 있는지 체크
	private static boolean canEat (int[][] board, int[][] distanceBoard, Shark shark, int i, int j) {
		// 물고기인지, 상어가 갈 수 있는지, 상어가 먹을 수 있는지
		if ((board[i][j] > 0 && board[i][j] < 7) && distanceBoard[i][j] > 1 && board[i][j] < shark.size) return true;
		return false;
	}
	
	// 엄마 상어 부를 조건
	private static boolean callMother (int[][] board, int[][] distanceBoard, Shark shark) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (canEat(board, distanceBoard, shark, i, j)) return false;
			}
		}
		return true;
	}
	
	// 현재 위치로부터 물고기 거리 정보 갱신
	private static int[][] updateDistance (int[][] board, int N, Shark shark) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1}; 
		
		Queue<int[]> queue = new LinkedList<>();
		
		int[][] distanceBoard = new int[N][N];
		distanceBoard[shark.x][shark.y] = 1;
		
		queue.add(new int[] {shark.x, shark.y, 1});
	
		// distanceBoard 업데이트로 거리 확보
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];
			int distance = current[2];
			
			for (int d = 0; d < 4; d++) {
				int nextX = x + dx[d];
				int nextY = y + dy[d];
				// 보드 범위를 넘거나, 상어보다 크거나, 한번 지나간 곳이면 스킵
				if (outOfRange(N, nextX, nextY) || board[nextX][nextY] > shark.size || distanceBoard[nextX][nextY] != 0) continue;
				distanceBoard[nextX][nextY] = distance + 1;
				queue.offer(new int[] {nextX, nextY, distance + 1});
			}
		}
		
		return distanceBoard;
	}
	
	private static boolean outOfRange(int N, int x, int y) {
		if (x < 0 || y < 0 || x == N || y == N) return true;
		return false;
	}
}
