package practice;

import java.io.*;
import java.util.*;

public class BOJ17779 {
	public static int N;
	public static int d1, d2;
	public static int[][] board;
	public static int total;

	public static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		board = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				total += board[i][j];
			}
		}
		
		result = Integer.MAX_VALUE;
		for (int x = 1; x <= N; x++) {
			for (int y = 1; y <= N; y++) {
				for (d1 = 1; d1 <= N; d1++) {
					for (d2 = 1; d2 <= N; d2++) {
						if (x + d1 + d2 > N) continue;
						if (y - d1 < 1 || y + d2 > N) continue;
						check(x, y);
					}
				}
			}
		}

		System.out.println(result);
	}

	public static void check(int x, int y) {
		int[][] lines = new int[N + 1][N + 1];
		for (int i = 0; i <= d1; i++) lines[x + i][y - i] = 5;
		for (int i = 0; i <= d2; i++) lines[x + i][y + i] = 5;
		for (int i = 0; i <= d2; i++) lines[x + d1 + i][y - d1 + i] = 5;
		for (int i = 0; i <= d1; i++) lines[x + d2 + i][y + d2 - i] = 5;
		
		int[] areas = new int[5];
		for (int i = 1; i < x + d1; i++) {
			for (int j = 1; j <= y; j++) {
				if (lines[i][j] == 5) break;
				areas[0] += board[i][j];
			}
		}
		
		for (int i = 1; i <= x + d2; i++) {
			for (int j = N; j > y; j--) {
				if (lines[i][j] == 5) break;
				areas[1] += board[i][j];
			}
		}
		
		for (int i = x + d1; i <= N; i++) {
			for (int j = 1; j < y - d1 + d2; j++) {
				if (lines[i][j] == 5) break;
				areas[2] += board[i][j];
			}
		}
		
		for (int i = x + d2 + 1; i <= N; i++) {
			for (int j = N; j >= y - d1 + d2; j--) {
				if (lines[i][j] == 5) break;
				areas[3] += board[i][j];
			}
		}
		
		areas[4] = total;
		for (int i = 0; i < 4; i++) areas[4] -= areas[i];
		
		Arrays.sort(areas);
		
		result = Math.min(result, areas[4] - areas[0]);
	}
}
