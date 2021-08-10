package swea.d3.d3_11315;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("/Users/dj/Desktop/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();

		int[] dx = {-1, 0, 1, 1};
		int[] dy = {1, 1, 1, 0};
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[][] board = new char[N][N];
			for (int i = 0; i < N; i++) {
				board[i] = br.readLine().toCharArray();
			}
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == 'o') {
						for (int d = 0; d < 4; d++) {
							int tempCount = 1;
							int x = i;
							int y = j;
							for (int k = 0; k < 4; k++) {
								int nx = x + dx[d];
								int ny = y + dy[d];
								
								if (nx < 0 || ny < 0 || nx == N || ny == N) break;
								if (board[nx][ny] == 'o') {
									tempCount++;
									x = nx;
									y = ny;
								} else break;
							}
							if (tempCount >= 5) {
								flag = true;
								break;
							}
						}
					}
				}
			}
			
			answer.append("#").append(tc).append(" ").append(flag ? "YES" : "NO").append("\n");
		}
		System.out.println(answer);
	}
}
