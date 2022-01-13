import java.io.*;
import java.util.*;

class Main
{
	private static int R, C, N;
	private static char[][] board;
	
	private static int[] dx, dy;
	
	private static final char BOMB = 'O';
	private static final char BOMB2 = 'o';
	private static final char EMPTY = '.';
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder answer = new StringBuilder();
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken()) - 1;
		
		board = new char[R][C];
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		dx = new int[]{-1, 1, 0, 0};
		dy = new int[]{0, 0, -1, 1};
		
		
		if (N % 2 == 1) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					answer.append(BOMB);
				}
				answer.append("\n");
			}
		} else {
			int count = N / 2;
			for (int i = 0; i < count; i++) {
				game();
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					answer.append(board[i][j]);
				}
				answer.append("\n");
			}
		}
		
		System.out.println(answer);
	}
	
	private static void game() {
		attack();
		recovery();
	}
	
	private static void attack() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == BOMB) {
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						
						if (outOfRange(nx, ny)) continue;
						if (board[nx][ny] == EMPTY) board[nx][ny] = BOMB2;
					}
				}
			}
		}
	}
	
	private static void recovery() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == EMPTY) board[i][j] = BOMB;
				else board[i][j] = EMPTY;
			}
		}
	}
	
	private static boolean outOfRange(int x, int y) {
		if (x < 0 || y < 0 || x == R || y == C) return true;
		return false;
	}
}