package day25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1194 {
	public static class User {
		int x, y;
		List<Character> keys;
		
		public User (int x, int y) {
			this.x = x;
			this.y = y;
			this.keys = new ArrayList<Character>();
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		

		Queue<int[][]> queue = new LinkedList<int[][]>();
		char[][] board = new char[N][M];
		for (int i = 0; i < N; i++) {
			char[] charArray = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				board[i][j] = charArray[j];
				if (charArray[j] == '0') queue.offer(new int[][] {{i, j, 0, 0}, {0, 0, 0, 0, 0, 0}});	// x, y, dist & keys
			}
		}
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		boolean[][][] visited = new boolean[N][M][(int)Math.pow(2, 6)];
		while (!queue.isEmpty()) {
			int[][] current = queue.poll();
			
			if (visited[current[0][0]][current[0][1]][current[0][3]]) continue;
			visited[current[0][0]][current[0][1]][current[0][3]] = true;
			
			for (int d = 0; d < 4; d++) {
				int nextX = current[0][0] + dx[d];
				int nextY = current[0][1] + dy[d];

				int curKey = current[0][3];
				if (outOfRange(N, M, nextX, nextY) || board[nextX][nextY] == '#' || visited[nextX][nextY][curKey]) continue;
				
				int[] keyClone = Arrays.copyOf(current[1], current[1].length);
				if (board[nextX][nextY] >= 'A' && board[nextX][nextY] <= 'F') {	// 열쇠 있어야 딸 수 있는 곳
					int keyIndex = board[nextX][nextY] - 'A';	// 키 인덱스 지정
					if (keyClone[keyIndex] == 0) continue;
				} else if (board[nextX][nextY] >= 'a' && board[nextX][nextY] <= 'f') {	// 열쇠 위치
					int keyIndex = board[nextX][nextY] - 'a';	// 키 인덱스 지정
					if (keyClone[keyIndex] == 0) {
						keyClone[keyIndex] = 1;
						curKey = 0;
						for (int i = 0; i < 6; i++) 
							curKey += keyClone[i] * (int)Math.pow(2, 5 - i);
					}
				} else if (board[nextX][nextY] == '1') {	// 종료
					System.out.println(current[0][2] + 1);
					System.exit(0);
				}

				queue.offer(new int[][] {{nextX, nextY, current[0][2] + 1, curKey}, keyClone});
			}
		}
		System.out.println(-1);
	}
	
	public static boolean outOfRange(int N, int M, int x, int y) {
		if (x < 0 || y < 0 || x == N || y == M) return true;
		return false;
	}
}
