package hwalgo13_서울_07반_장동재;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[] checked;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
		char[][] board = new char[R][C];
		
		for (int i = 0; i < R; i++) board[i] = br.readLine().toCharArray();
		
		max = Integer.MIN_VALUE;
		checked = new boolean[26];
		checked[board[0][0] - 'A'] = true;
		dfs(board, 0, 0, 1);
		
		System.out.println(max);
	}
	
	public static void dfs(char[][] board, int x, int y, int count) {
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if (outOfRange(board, nextX, nextY)) continue;
			if (!checked[board[nextX][nextY] - 'A']) {
				checked[board[nextX][nextY] - 'A'] = true;	// 들어갈 때 체크 해주고
				dfs(board, nextX, nextY, count + 1);
				checked[board[nextX][nextY] - 'A'] = false;	// 나올 때 체크 해제
			}
		}
		max = Math.max(max, count);
	}
	
	public static boolean outOfRange(char[][] board, int x, int y) {
		if (x < 0 || y < 0 || x == board.length || y == board[0].length) return true;
		return false;
	}
}
