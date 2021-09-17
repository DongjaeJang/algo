package day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Position {
		int x, y;
		
		public Position (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		List<Position> posList = new ArrayList<>();
		List<Position> virus = new ArrayList<>();
		int[][] board = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 0) posList.add(new Position(i, j));
				else if (board[i][j] == 2) virus.add(new Position(i, j));
			}
		}
		
		int SIZE = posList.size();
		int[] array = new int[SIZE];
		for (int i = SIZE - 1; i > SIZE - 4; i--) array[i] = 1;
		
		int result = 0;
		do {
			int[][] copyBoard = copyBoard(board, N, M);
			
			for (int i = 0; i < SIZE; i++) {
				if (array[i] == 1) {
					Position current = posList.get(i);
					copyBoard[current.x][current.y] = 1;
				}
			}
			bfs(copyBoard, virus);
			result = Math.max(result, countArea(copyBoard));
		} while (np(array));
		
		System.out.println(result);
	}

	private static int countArea(int[][] copyBoard) {
		int count = 0;
		for (int i = 0; i < copyBoard.length; i++) {
			for (int j = 0; j < copyBoard[0].length; j++) {
				if (copyBoard[i][j] == 0) count++;
			}
		}
		return count;
	}

	private static void bfs(int[][] copyBoard, List<Position> virus) {
		Queue<Position> queue = new LinkedList<>();
		for (int i = 0; i < virus.size(); i++) queue.offer(virus.get(i));
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		while (!queue.isEmpty()) {
			Position current = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nextX = current.x + dx[d];
				int nextY = current.y + dy[d];
				
				if (outOfRange(copyBoard.length, copyBoard[0].length, nextX, nextY) || copyBoard[nextX][nextY] != 0) continue;
				copyBoard[nextX][nextY] = 2;
				queue.add(new Position(nextX, nextY));
			}
		}
	}

	private static int[][] copyBoard(int[][] board, int N, int M) {
		int[][] copyBoard = new int[N][M];
		for (int i = 0; i < N; i++) copyBoard[i] = Arrays.copyOf(board[i], M);
		return copyBoard;
	}

	private static boolean np(int[] array) {
		int N = array.length;
		
		// step 1	꼭대기 찾기
		int i = N - 1;
		while (i > 0 && array[i - 1] >= array[i]) --i;
		
		if (i == 0) return false;
		
		int j = N - 1;
		while (array[i - 1] >= array[j]) --j;
		
		swap(array, i - 1, j);
		
		int k = N - 1;
		while (i < k) swap(array, i++, k--);
		return true;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	private static boolean outOfRange(int N, int M, int x, int y) {
		if (x < 0 || y < 0 || x == N || y == M) return true;
		return false;
	}
}
