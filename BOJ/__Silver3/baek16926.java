package day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	// 행
		int M = Integer.parseInt(st.nextToken());	// 열
		int R = Integer.parseInt(st.nextToken());	// 횟수
		
		// 보드 생성
		int[][] board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = Math.min(N, M) / 2;
		// 돌리기
		for (int i = 0; i < R; i++) {
			rotateBoard(board, N, M, count);
		}
		
		// 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				answer.append(board[i][j]);
				if (j < M - 1)
					answer.append(" ");
			}
			answer.append("\n");
		}
		
		System.out.println(answer);
	}

	private static void rotateBoard(int[][] board, int n, int m, int count) {
		for (int i = 0; i < count; i++) {
			int row = i, col = i;
			int nx, ny;
			int startValue = board[row][col];
			
			for (int d = 0; d < 4; d++) {
				int max = d % 2 == 0 ? (m - i * 2) - 1 : (n - i * 2) - 1;
				for (int j = 0; j < max; j++) {
					nx = row + dx[d];
					ny = col + dy[d];
					board[row][col] = board[nx][ny];
					row = nx;
					col = ny;
				}
			}
			
			board[row-dx[3]][col-dy[3]] = startValue;
		}
	}
}
