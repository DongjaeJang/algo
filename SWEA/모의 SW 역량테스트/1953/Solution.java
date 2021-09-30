package hwalgo27_서울_07반_장동재;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Solution {
	public static class Position {
		int x, y, index, second;
		
		public Position (int x, int y, int index, int second) {
			this.x = x;
			this.y = y;
			this.index = index;
			this.second = second;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		int[] dlen = {0, 4, 2, 2, 2, 2, 2, 2};
		int[][] moveList = {{}, {0, 1, 2, 3}, {0, 1}, {2, 3}, {0, 3}, {1, 3}, {1, 2}, {0, 2}};
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken()) - 1;
			
			int[][] board = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			boolean[][] visited = new boolean[N][M];
			int result = 0;
			
			Queue<Position> queue = new LinkedList<>();
			queue.add(new Position(R, C, board[R][C], 0));
			
			while (!queue.isEmpty()) {
				Position current = queue.poll();
				
				if (current.second > L) break;
				if (visited[current.x][current.y]) continue;
				
				visited[current.x][current.y] = true;
				result++;
				
				for (int i = 0; i < dlen[current.index]; i++) {
					int nextX = current.x + dx[moveList[current.index][i]];
					int nextY = current.y + dy[moveList[current.index][i]];
					
					if (outOfRange(N, M, nextX, nextY) || board[nextX][nextY] == 0 || visited[nextX][nextY]) continue;
					int nextIndex = board[nextX][nextY];
					if (moveList[current.index][i] == 0 && (nextIndex == 3 || nextIndex == 4 || nextIndex == 7)) continue;
					else if (moveList[current.index][i] == 1 && (nextIndex == 3 || nextIndex == 5 || nextIndex == 6)) continue;
					else if (moveList[current.index][i] == 2 && (nextIndex == 2 || nextIndex == 6 || nextIndex == 7)) continue;
					else if (moveList[current.index][i] == 3 && (nextIndex == 2 || nextIndex == 4 || nextIndex == 5)) continue;
					
					queue.offer(new Position(nextX, nextY, board[nextX][nextY], current.second + 1));
				}
			}
			
			answer.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(answer);
	}
	
	public static boolean outOfRange(int N, int M, int x, int y) {
		if (x < 0 || y < 0 || x == N || y == M) return true;
		return false;
	}
}
