package hwalgo12_서울_07반_장동재;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		answer = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		char[][] board = new char[N][N];
		for (int i = 0; i < N; i++) board[i] = br.readLine().toCharArray();
		
		quadTree(board, N, 0, 0);
		System.out.println(answer);
	}
	
	public static void quadTree(char[][] board, int N, int row, int col) {
		if (allSame(board, N, row, col)) {
			answer.append(board[row][col]);
			return ;
		}
		
		answer.append("(");
		quadTree(board, N / 2, row, col);
		quadTree(board, N / 2, row, col + N / 2);
		quadTree(board, N / 2, row + N / 2, col);
		quadTree(board, N / 2, row + N / 2, col + N / 2);
		answer.append(")");		
	}
	
	public static boolean allSame(char[][] board, int N, int row, int col) {
		char c = board[row][col];
		for (int i = row; i < row + N; i++) {
			for (int j = col; j < col + N; j++) {
				if (board[i][j] != c) return false;
			}
		}
		return true;
	}
}
