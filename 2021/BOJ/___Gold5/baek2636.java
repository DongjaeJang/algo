package day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int second = 0;
		int count = 0;
		
		while (checkRemain(board)) {
			checkOutAir(board);
			count = countCheese(board);
			melt(board);
			restoreAir(board);
			second++;
		}
		
		System.out.println(second);
		System.out.println(count);
	}

	// 치즈가 남아있는지 체크
	public static boolean checkRemain(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 1) return true;
			}
		}
		return false;
	}
	
	// 외부 공기 체크
	public static void checkOutAir(int[][] board) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0, 0});
		board[0][0] = 0;
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nextX = current[0] + dx[d];
				int nextY = current[1] + dy[d];
				
				if (outOfRange(board, nextX, nextY)) continue;
				if (board[nextX][nextY] == 0) {
					board[nextX][nextY] = -1;
					queue.offer(new int[] {nextX, nextY});
				}
			}
		}
	}
	
	// 개수 세기
	public static int countCheese(int[][] board) {
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 1) count++;
			}
		}
		return count;
	}
	
	// 치즈 녹이기
	public static void melt(int[][] board) {
		// 치즈 포인트 저장
		List<int[]> points = new ArrayList<>();
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		// 사이드 치즈 찾기
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 1) {
					boolean flag = false;
					for (int d = 0; d < 4; d++) {
						int nextX = i + dx[d];
						int nextY = j + dy[d];
						
						if (outOfRange(board, nextX, nextY) || board[nextX][nextY] == -1) {
							flag = true;
							break;
						}
					}
					if (flag)
						points.add(new int[] {i, j});
				}
			}
		}
		
		for (int i = 0; i < points.size(); i++) {
			int[] current = points.get(i);
			board[current[0]][current[1]] = -1;
		}
	}
	
	// 공기층 다시 설정
	public static void restoreAir(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == -1) board[i][j] = 0;
			}
		}
	}
	
	// 범위 체크
	public static boolean outOfRange(int[][] board, int x, int y) {
		if (x < 0 || y < 0 || x == board.length|| y == board[0].length) return true;
		return false;
	}
}
