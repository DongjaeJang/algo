package swea.d2.d2_1961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			answer.append("#").append(i).append("\n");
			int n = Integer.parseInt(br.readLine());
			int[][] board = new int[n][n];

			for (int row = 0; row < n; row++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int col = 0; col < n; col++) {
					board[row][col] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] board_90 = rotate90(board, n);
			int[][] board_180 = rotate180(board, n);
			int[][] board_270 = rotate270(board, n);

			for (int row = 0; row < n; row++) {
				for (int col = 0; col < n; col++) {
					answer.append(board_90[row][col]);
				}
				answer.append(" ");
				for (int col = 0; col < n; col++) {
					answer.append(board_180[row][col]);
				}
				answer.append(" ");
				for (int col = 0; col < n; col++) {
					answer.append(board_270[row][col]);
				}
				answer.append("\n");
			}
		}
		System.out.println(answer);
	}


	private static int[][] rotate90(int[][] board, int n) {
		int[][] result = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = board[n-j-1][i];
			}
		}

		return result;
	}

	private static int[][] rotate180(int[][] board, int n) {
		int[][] result = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = board[n - i - 1][n - j - 1];
			}
		}

		return result;
	}
	

	private static int[][] rotate270(int[][] board, int n) {
		int[][] result = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = board[j][n - i - 1];
			}
		}

		return result;
	}
}
