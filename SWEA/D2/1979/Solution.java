package swea.d2.d2_1979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int testNum = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testNum; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[][] board = new int[N + 2][N + 2];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int result = 0;
			for (int row = 1; row <= N; row++) {
				for (int col = 1; col <= N; col++) {
					if (board[row][col] == 1)
						result += checkAround(board, row, col, K);
				}
			}

			sb.append("#").append(tc).append(" ").append(result / 2).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int checkAround(int[][] board, int row, int col, int K) {
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		int count = 0;
		for (int d = 0; d < 4; d++) {
			if (board[row - dx[d]][col - dy[d]] != 0)
				continue;
			boolean flag = true;
			for (int k = 0; k < K; k++) {
				if (board[row + dx[d] * k][col + dy[d] * k] != 1) {
					flag = false;
					break;
				}
			}
			if (flag) {
				if (board[row+dx[d]*K][col+dy[d]*K] == 1) continue;
				count++;
			}
		}

		return count;
	}
}
