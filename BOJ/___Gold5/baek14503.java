package boj_self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503 {
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	
	public static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = 0;
		
		while (true) {
			// 1. 현재 위치 청소
			if (board[r][c] == 0) {
				board[r][c] = 2;
				++result;
			}

			// 2. 다음 위치 찾기
			boolean flag = true;
			for (int i = 0; i < 4; i++) {
				--d;
				if (d < 0) d += 4;
				if (checkLeft(board, N, M, r, c, d)) {
					flag = false;
					
					r += dx[d];
					c += dy[d];
					break;
				}
			}
			// 4방향 모두 못갈 때
			if (flag) {
				int tempD = d - 2;
				if (tempD < 0) tempD += 4;
				
				int backX = r + dx[tempD];
				int backY = c + dy[tempD];
				
				if (board[backX][backY] == 1) break;
				else {
					r = backX;
					c = backY;
				}
			}
		}
		
		System.out.println(result);
	}
	
	public static boolean checkLeft(int[][] board, int N, int M, int x, int y, int d) {
		int nextX = x + dx[d];
		int nextY = y + dy[d];
		
		if (outOfRange(N, M, nextX, nextY) || board[nextX][nextY] != 0) return false;
		return true;
	}
	
	public static boolean outOfRange(int N, int M, int x, int y) {
		if (x < 0 || y < 0 || x == N || y == M) return true;
		return false;
	}
}
