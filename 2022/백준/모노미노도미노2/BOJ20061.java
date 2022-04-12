package practice;

import java.io.*;
import java.util.*;

/**
 * type 1 : 1 x 1 type 2 : 1 x 2 type 3 : 2 x 1
 */
public class BOJ20061 {

	public static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] green = new int[6][4];
		int[][] blue = new int[6][4];
		result = 0;

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int type = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			move(green, type, x, y);
			move(blue, type == 1 ? 1 : type == 2 ? 3 : 2, y, x);
		}

		int sum = 0;
		for (int i = 2; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				sum += green[i][j] + blue[i][j];
			}
		}
		System.out.println(result);
		System.out.println(sum);
	}

	public static void move(int[][] board, int type, int x, int y) {
		// 최대 깊이찾아서 내려가기
		int n = 0;
		switch (type) {
		case 1:
			while (n < 5 && board[n + 1][y] == 0)
				n++;
			board[n][y] = 1;
			break;
		case 2:
			while (n < 5 && board[n + 1][y] == 0 && board[n + 1][y + 1] == 0)
				n++;
			board[n][y] = 1;
			board[n][y + 1] = 1;
			break;
		case 3:
			while (n < 4 && board[n + 1][y] == 0 && board[n + 2][y] == 0)
				n++;
			board[n][y] = 1;
			board[n + 1][y] = 1;
			break;
		}

		// 아래에서부터 행이 꽉 찼는지 확인
		n = 5;
		while (n > 1) {
			int sum = board[n][0] + board[n][1] + board[n][2] + board[n][3];
			if (sum == 4) {
				for (int i = n; i > 0; i--) {
					board[i] = Arrays.copyOf(board[i - 1], 4);
				}
				board[0] = new int[4];
				result++;
				
				continue;
			} else n--;
		}
		
		// 연한 줄에 있을 때 보드 한줄씩 내림 처리
		for (int k = 0; k < 2; k++) {
			if (board[1][0] + board[1][1] + board[1][2] + board[1][3] > 0) {
				for (int i = 5; i > 0; i--) {
					board[i] = Arrays.copyOf(board[i - 1], 4);
				}
				board[0] = new int[4];
			}
		}
	}
}
