package swea.d2.d2_1954;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for (int i = 1; i <= testCase; i++) {
			int num = sc.nextInt();

			System.out.printf("#%d%n", i);
			makeSnail(num);
		}
	}

	private static void makeSnail(int num) {
		int[][] board = new int[num][num];
		int maxNum = (int) Math.pow(num, 2);
		int count = 1;

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		int d = 0;

		int x = 0, y = 0;

		do {
			board[x][y] = count++;
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (outOfRange(num, nx, ny) || board[nx][ny] != 0)
				d++;
			if (d > 3)
				d %= 4;
			
			x += dx[d];
			y += dy[d];

		} while (count <= maxNum);
		
		for (int i = 0; i < num; i++)
			for (int j = 0; j < num; j++)
				if (j == (num - 1)) System.out.println(board[i][j]);
				else System.out.printf("%d ", board[i][j]);
	}

	private static boolean outOfRange(int num, int x, int y) {
		if (x < 0 || y < 0 || x == num || y == num)
			return true;
		return false;
	}
}
