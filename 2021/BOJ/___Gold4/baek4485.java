package day25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ4485 {
	public static class Node implements Comparable<Node>{
		int x, y, w;
		
		public Node (int x, int y, int w) {
			this.x = x; this.y = y; this.w = w;
		}
		
		public int compareTo (Node o) {
			return this.w - o.w;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int index = 1;
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			
			int[][] board = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[] dx = {-1, 1, 0, 0};
			int[] dy = {0, 0, -1, 1};
			
			int[][] dp = new int[N][N];
			for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) dp[i][j] = 9 * 125 + 1;
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(0, 0, board[0][0]));
			dp[0][0] = board[0][0];
			
			while (!pq.isEmpty()) {
				Node current = pq.poll();
				
				for (int d = 0; d < 4; d++) {
					int nextX = current.x + dx[d];
					int nextY = current.y + dy[d];
					
					if (outOfRange(N, nextX, nextY) || dp[nextX][nextY] <= dp[current.x][current.y] + board[nextX][nextY]) continue;
					dp[nextX][nextY] = dp[current.x][current.y] + board[nextX][nextY];
					pq.offer(new Node(nextX, nextY, board[nextX][nextY]));
				}
			}
			
			answer.append("Problem ").append(index++).append(": ").append(dp[N - 1][N - 1]).append("\n");
		}
		System.out.println(answer);
	}
	
	public static boolean outOfRange(int N, int x, int y) {
		if (x < 0 || y < 0 || x == N || y == N) return true;
		return false;
	}
}
