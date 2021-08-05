package swea.d2.d2_1974;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			int[][] board = new int[9][9];

			for (int row = 0; row < 9; row++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int col = 0; col < 9; col++) {
					board[row][col] = Integer.parseInt(st.nextToken());
				}
			}

			boolean flag = true;
			for (int row = 0; row < 9; row++) {
				for (int col = 0; col < 9; col++) {
					if (!checkRow(board, row))
						flag = false;
					if (!checkCol(board, col))
						flag = false;
					if (row % 3 == 0 && col % 3 == 0)
						if (!checkRect(board, row, col))
							flag = false;
				}
				if (!flag) break;
			}
			
			answer.append("#").append(i).append(" ").append(flag ? 1 : 0).append("\n");
		}
		System.out.println(answer);
	}

	private static boolean checkRect(int[][] board, int row, int col) {
		boolean[] isExist = new boolean[9];
		
		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				int current = board[i][j];
				if (isExist[current - 1])
					return false;
				else
					isExist[current - 1] = true;
			}
		}
		
		return true;
	}

	private static boolean checkCol(int[][] board, int col) {
		boolean[] isExist = new boolean[9];

		for (int i = 0; i < 9; i++) {
			int current = board[i][col];
			if (isExist[current - 1])
				return false;
			else
				isExist[current - 1] = true;
		}

		return true;
	}

	private static boolean checkRow(int[][] board, int row) {
		boolean[] isExist = new boolean[9];

		for (int i = 0; i < 9; i++) {
			int current = board[row][i];
			if (isExist[current - 1])
				return false;
			else
				isExist[current - 1] = true;
		}

		return true;
	}
}
