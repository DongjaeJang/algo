package boj_self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3190 {
	public static class Position {
		int x, y;
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Position [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int[][] board = new int[N + 2][N + 2];
		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < N + 2; j++) {
				if (i == 0 || j == 0 || i == N + 1 || j == N + 1) board[i][j] = 1;
			}
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;
		}
		
		int L = Integer.parseInt(br.readLine());
		Map<Integer, Character> moveList = new HashMap();
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			moveList.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
		}
	
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		int d = 1;
		
		List<Position> snake = new ArrayList<>();
		board[1][1] = 1;
		snake.add(new Position(1, 1));
		
		int second = 0;
		
		for (;;) {
			++second;
			Position head = snake.get(snake.size() - 1);	// 끝에 추가 된게 머리
			int nextX = head.x + dx[d];
			int nextY = head.y + dy[d];
			
			if (board[nextX][nextY] == 1) break;

			if (board[nextX][nextY] == 0) {
				Position pos = snake.remove(0);
				board[pos.x][pos.y] = 0;
			}
			snake.add(new Position(nextX, nextY));
			for (int i = 0; i < snake.size(); i++) {
				Position pos = snake.get(i);
				board[pos.x][pos.y] = 1;
			}
			
			if (moveList.containsKey(second)) {
				char op = moveList.get(second);
				
				if (op == 'L') d -= 1;
				else if (op == 'D') d += 1;
				
				if (d < 0) d += 4;
				else if (d >= 4) d -= 4;
			}
		}
		System.out.println(second);
	}
}
