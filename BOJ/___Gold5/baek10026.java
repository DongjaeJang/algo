package hwalgo17_서울_07반_장동재;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char[][] normalBoard = new char[N][N];
		char[][] abnormalBoard = new char[N][N];
		
		for (int i = 0; i < N; i++) normalBoard[i] = br.readLine().toCharArray();
		for (int i = 0; i < N; i++) abnormalBoard[i] = Arrays.copyOf(normalBoard[i], N);
		
		int normalCount = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (normalBoard[i][j] != '0') {
					normalDFS(normalBoard, i, j, normalBoard[i][j]);
					normalCount++;
				}
			}
		}
		
		int abnormalCount = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (abnormalBoard[i][j] != '0') {
					abnormalDFS(abnormalBoard, i, j, abnormalBoard[i][j]);
					abnormalCount++;
				}
			}
		}
		
		System.out.println(normalCount + " " + abnormalCount);
	}

	public static void normalDFS (char[][] board, int x, int y, char c) {
		board[x][y] = '0';
		
		for (int d = 0; d < 4; d++) {
			int nextX = x + dx[d];
			int nextY = y + dy[d];
			
			if (outOfRange(board.length, nextX, nextY) || board[nextX][nextY] != c || board[nextX][nextY] == '0') continue;
			normalDFS(board, nextX, nextY, c);
		}
	}
	
	private static void abnormalDFS(char[][] board, int x, int y, char c) {
		board[x][y] = '0';
		
		for (int d = 0; d < 4; d++) {
			int nextX = x + dx[d];
			int nextY = y + dy[d];
			
			if (outOfRange(board.length, nextX, nextY) || board[nextX][nextY] == '0') continue;
			if ((c == 'B' && board[nextX][nextY] == 'B') || (c != 'B' && board[nextX][nextY] != 'B'))
				abnormalDFS(board, nextX, nextY, c);
		}
	}
	
	private static boolean outOfRange(int N, int x, int y) {
		if (x < 0 || y < 0 || x == N || y == N) return true;
		return false;
	}
}
