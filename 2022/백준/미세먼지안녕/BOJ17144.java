package practice;

import java.io.*;
import java.util.*;

public class BOJ17144 {
	public static int R, C, T;
	public static int[][] board;
	public static int upRow;
	public static int downRow;
	
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		board = new int[R][C];
		
		boolean flag = true;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == -1) {
					if (flag) { upRow = i; flag = false; }
					else downRow = i;
				}
			}
		}
		int second = 0;

		while (second++ < T) {
			moveDust();
			doCleaner();
		}
		
		System.out.println(countDust());
	}

	public static void moveDust() {
		int[][] saveBoard = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] < 1) continue;
				
				int divDust = board[i][j] / 5;
				
				for (int d = 0; d < 4; d++) {
					int nextX = i + dx[d];
					int nextY = j + dy[d];
					
					if (outOfRange(nextX, nextY) || board[nextX][nextY] == -1) continue;
					saveBoard[nextX][nextY] += divDust;
					board[i][j] -= divDust;
				}
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				board[i][j] += saveBoard[i][j];
			}
		}
	}

	public static void doCleaner() {
		// upside
		int x = upRow - 1;
		int y = 0;
		
		while (x > 0) {
			board[x][y] = board[x - 1][y];
			x--;
		}
		
		while (y < C - 1) {
			board[x][y] = board[x][y + 1];
			y++;
		}
		
		while (x < upRow) {
			board[x][y] = board[x + 1][y];
			x++;
		}
		
		while (y > 1) {
			board[x][y] = board[x][y - 1];
			y--;
		}
		
		board[x][y] = 0;
		
		// downside
		x = downRow + 1;
		y = 0;
		
		while (x < R - 1) {
			board[x][y] = board[x + 1][y];
			x++;
		}
		
		while (y < C - 1) {
			board[x][y] = board[x][y + 1];
			y++;
		}
		
		while (x > downRow) {
			board[x][y] = board[x - 1][y];
			x--;
		}
		
		while (y > 1) {
			board[x][y] = board[x][y - 1];
			y--;
		}
		board[x][y] = 0;
	}
	
	public static int countDust() {
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == -1) continue;
				result += board[i][j];
			}
		}
		return result;
	}
	
	public static boolean outOfRange(int x, int y) {
		if (x < 0 || x == R || y < 0 || y == C) return true;
		return false;
	}
}
