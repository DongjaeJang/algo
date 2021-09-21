package boj_self;

import java.io.*;
import java.util.*;

public class Programmers_카카오프렌즈_컬러링북 {
	int index = 0;
	int maxSize = 0;
	int[] dx = { -1, 1, 0, 0 };
	int[] dy = { 0, 0, -1, 1 };

	public int[] solution(int m, int n, int[][] picture) {
		boolean[][] checked = new boolean[m][n];
		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {
				if (!checked[x][y] && picture[x][y] != 0) {
					indexArea(picture, checked, m, n, x, y, picture[x][y]);
				}
			}
		}

		int[] answer = new int[2];
		answer[0] = index;
		answer[1] = maxSize;
		return answer;
	}

	public void indexArea(int[][] arr, boolean[][] checked, int m, int n, int x, int y, int color) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y });
		checked[x][y] = true;

		int tempSize = 1;
		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = current[0] + dx[i];
				int nextY = current[1] + dy[i];

				if (outOfRange(m, n, nextX, nextY) || arr[nextX][nextY] != color)
					continue;

				if (checked[nextX][nextY])
					continue;
				checked[nextX][nextY] = true;
				queue.offer(new int[] { nextX, nextY });
				tempSize++;
			}
		}
		maxSize = Math.max(maxSize, tempSize);
		index++;
	}

	public boolean outOfRange(int m, int n, int x, int y) {
		if (x < 0 || y < 0 || x == m || y == n)
			return true;
		return false;
	}

}
