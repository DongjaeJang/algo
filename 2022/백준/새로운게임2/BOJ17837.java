package practice;

import java.io.*;
import java.util.*;

public class BOJ17837 {
	public static int N, K;
	public static int[][] board;
	public static List<Horse> horses;
	public static List<Integer>[][] orders;
	
	public static int[] dx = {0, 0, -1, 1};
	public static int[] dy = {1, -1, 0, 0};
	
	public static final int WHITE = 0;
	public static final int RED = 1;
	public static final int BLUE = 2;
	
	public static int turn;
	
	public static class Horse {
		int x, y;
		int d;
		
		public Horse (int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		orders = new List[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				orders[i][j] = new ArrayList<>();
			}
		}
		
		horses = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;
			
			horses.add(new Horse(x, y, d));
			orders[x][y].add(i);
		}
		
		turn = 0;
		while (turn++ <= 1000) {
			moveHorses();
		}
		System.out.println(-1);
	}
	
	public static void moveHorses() {
		for (int i = 0; i < K; i++) {
			Horse horse = horses.get(i);
			
			int curX = horse.x;
			int curY = horse.y;
			
			int nextX = curX + dx[horse.d];
			int nextY = curY + dy[horse.d];
			
			if (outOfRange(nextX, nextY) || board[nextX][nextY] == BLUE) {	// 방향 반대로
				horses.get(i).d = horse.d % 2 == 0 ? horse.d + 1 : horse.d - 1;
				horse.d = horses.get(i).d;
				
				nextX = curX + dx[horse.d];
				nextY = curY + dy[horse.d];
			} 
			
			if (outOfRange(nextX, nextY) || board[nextX][nextY] == BLUE) continue;	// 또 부딪히거나 파랑이면 가만히
			else if (board[nextX][nextY] == RED) {
				while (true) {
					int curIdx = orders[curX][curY].remove(orders[curX][curY].size() - 1);
					
					horses.get(curIdx).x = nextX;
					horses.get(curIdx).y = nextY;
					
					orders[nextX][nextY].add(curIdx);
					if (curIdx == i) break;
				}
			} else if (board[nextX][nextY] == WHITE) {
				int idx = findIdx(i, curX, curY);
				while (true) {
					try {
						int curIdx = orders[curX][curY].remove(idx);
						
						horses.get(curIdx).x = nextX;
						horses.get(curIdx).y = nextY;
						
						orders[nextX][nextY].add(curIdx);
					} catch(Exception e) {
						break;
					}
				}
			}
			
			if (orders[nextX][nextY].size() >= 4) {
				System.out.println(turn);
				System.exit(0);
			}
		}
	}
	
	public static int findIdx(int idx, int x, int y) {
		for (int i = 0; i < orders[x][y].size(); i++) {
			if (orders[x][y].get(i) == idx) return i;
		}
		return -1;
	}
	
	public static boolean outOfRange(int x, int y) {
		if (x < 0 || y < 0 || x == N || y == N) return true;
		return false;
	}
}
