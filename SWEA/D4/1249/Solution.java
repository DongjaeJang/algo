package day26;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static class Position {
		int x, y, weight;
		public Position (int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] board = new int[N][N];
			int[][] dp = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] charArray = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) board[i][j] = charArray[j] - '0';
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dp[i][j] = Integer.MAX_VALUE;
				}
			}
			
			Queue<Position> pq = new LinkedList<>();
			pq.offer(new Position(0, 0, board[0][0]));
			dp[0][0] = board[0][0];
			
			int[] dx = {-1, 1, 0, 0};
			int[] dy = {0, 0, -1, 1};
			
			boolean[][] visited = new boolean[N][N];
			while (!pq.isEmpty()) {
				Position current = pq.poll();
				visited[current.x][current.y] = true;
				for (int i = 0; i < 4; i++) {
					int nextX = current.x + dx[i];
					int nextY = current.y + dy[i];
					
					if (nextX < 0 || nextY < 0 || nextX == N || nextY == N || (dp[nextX][nextY] <= (dp[current.x][current.y] + board[nextX][nextY]))) continue;
					dp[nextX][nextY] = dp[current.x][current.y] + board[nextX][nextY];
					pq.offer(new Position(nextX, nextY, board[nextX][nextY]));
				}
			}
			
			answer.append("#").append(tc).append(" ").append(dp[N - 1][N - 1]).append("\n");
		}
		System.out.println(answer);
	}
}
