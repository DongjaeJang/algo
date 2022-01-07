package day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class CCTV {
		int sorts;
		int x;
		int y;
		
		public CCTV(int sorts, int x, int y) {
			this.sorts = sorts;
			this.x = x;
			this.y = y;
		}
	}
	static int min;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];
		min = Integer.MAX_VALUE;
		
		int cctvCount = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int current = Integer.parseInt(st.nextToken());
				if (current > 0 && current < 6) cctvCount++;
				board[i][j] = current;
			}
		}
		CCTV[] cctvs = new CCTV[cctvCount];

		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int current = board[i][j];
				if (current > 0 && current < 6) cctvs[idx++] = new CCTV(current, i, j);
			}
		}
		start(board, cctvs, cctvCount, 0);
		
		System.out.println(min);
	}
	
	public static void start(int[][] board, CCTV[] cctvs, int N, int count) {
		if (count == N) {
			min = Math.min(min, checkBlackArea(board));
			return;
		}
		
		if (cctvs[count].sorts == 5) {	// 5는 사방 전부 쏘니까 한번만 체크
			int[][] tempBoard = copyBoard(board);
			checkCctvArea(tempBoard, cctvs[count], 0);
			start(tempBoard, cctvs, N, count + 1);
		} else if (cctvs[count].sorts == 2) {	// 2는 앞뒤로 쏘니까 두번만 체크
			for (int d = 0; d < 2; d++) {
				int[][] tempBoard = copyBoard(board);
				checkCctvArea(tempBoard, cctvs[count], d);
				start(tempBoard, cctvs, N, count + 1);
			}
		} else {
			for (int d = 0; d < 4; d++) {	// 나머지는 4방 탐색
				if (cctvs[count].sorts == 1 && outOfRange(board, cctvs[count].x + dx[d], cctvs[count].y + dy[d])) continue;
				int[][] tempBoard = copyBoard(board);
				checkCctvArea(tempBoard, cctvs[count], d);
				start(tempBoard, cctvs, N, count + 1);
			}
		}
	}
	public static void updateLine(int[][] board, int x, int y, int d) {
		switch (d) {
		case 0 :	// 상
			for (int i = x - 1; i >= 0; i--) {
				if (outOfRange(board, i, y) || board[i][y] == 6) break;
				if (board[i][y] == 0) board[i][y] = 7;
			}
			break;
		case 1 :	// 우
			for (int i = y + 1; i < board[0].length; i++) {
				if (outOfRange(board, x, i) || board[x][i] == 6) break;
				if (board[x][i] == 0) board[x][i] = 7;
			}
			break;
		case 2 :	// 하
			for (int i = x + 1; i < board.length; i++) {
				if (outOfRange(board, i, y) || board[i][y] == 6) break;
				if (board[i][y] == 0) board[i][y] = 7;
			}
			break;
		case 3 :	// 좌
			for (int i = y - 1; i >= 0; i--) {
				if (outOfRange(board, x, i) || board[x][i] == 6) break;
				if (board[x][i] == 0) board[x][i] = 7;
			}
			break;
		}
	}
	
	public static void checkCctvArea(int[][] board, CCTV cctv, int d) {
		switch (cctv.sorts) {
		case 1 :
			updateLine(board, cctv.x, cctv.y, d);
			break;
		case 2 :
			for (int i = 0; i < 2; i++) updateLine(board, cctv.x, cctv.y, d + 2 * i);
			break;
		case 3 :
			for (int i = 0; i < 2; i++) updateLine(board, cctv.x, cctv.y, (d + i) % 4);
			break;
		case 4 :
			for (int i = 0; i < 3; i++) updateLine(board, cctv.x, cctv.y, (d + i) % 4);
			break;
		case 5 :
			for (int i = 0; i < 4; i++) updateLine(board, cctv.x, cctv.y, i);
			break;
		}
	}
	
	public static int checkBlackArea(int[][] board) {
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 0) count++;
			}
		}
		return count;
	}
	
	public static int[][] copyBoard(int[][] board) {
		int N = board.length;
		int M = board[0].length;
		
		int[][] tempBoard = new int[N][M];
		for (int i = 0; i < N; i++) tempBoard[i] = Arrays.copyOf(board[i], M);
		
		return tempBoard;
	}
	
	public static boolean outOfRange(int[][] board, int x, int y) {
		if (x < 0 || y < 0 || x == board.length || y == board[0].length) return true;
		else return false;
	}
}
