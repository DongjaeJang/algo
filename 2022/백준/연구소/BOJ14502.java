package practice;

import java.io.*;
import java.util.*;

public class BOJ14502 {
	public static final int EMPTY = 0;
	public static final int WALL = 1;
	public static final int VIRUS = 2;
	
	public static int N, M;
	public static int[][] board;
	public static int zeroCount, virusCount;
	public static List<Position> emptyPositions, virusPositions;
	
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static class Position {
		int x, y;
		
		public Position (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		zeroCount = 0; virusCount = 0;
		emptyPositions = new ArrayList<>();
		virusPositions = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				
				if (n == EMPTY) {
					zeroCount++;
					emptyPositions.add(new Position(i, j));
				} else if (n == VIRUS) {
					virusCount++;
					virusPositions.add(new Position(i, j));
				}
				board[i][j] = n;
			}
		}
		
		int[] array = new int[zeroCount];
		for (int i = zeroCount - 1; i > zeroCount - 4; i--) array[i] = 1;
		
		int result = -1;
		do {
			int[][] copyBoard = copyBoard(board);
			for (int i = 0; i < zeroCount; i++) {
				if (array[i] == 1) {
					Position pos = emptyPositions.get(i);
					copyBoard[pos.x][pos.y] = WALL;
				}
			}
			moveVirus(copyBoard);
			result = Math.max(result, countEmpty(copyBoard));
		} while (nextPermutation(array));
		
		System.out.println(result);
	}
	
	public static boolean nextPermutation (int[] array) {
		int N = array.length;
		
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
	
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static int[][] copyBoard(int[][] board) {
		int[][] copyBoard = new int[N][M];
		for (int i = 0; i < N; i++) copyBoard[i] = Arrays.copyOf(board[i], M);
		return copyBoard;
	}
	
	public static void moveVirus(int[][] copyBoard) {
		Queue<Position> queue = new LinkedList<>();
		for (int i = 0; i < virusCount; i++) {
			queue.offer(virusPositions.get(i));
		}
		
		while (!queue.isEmpty()) {
			Position pos = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nextX = pos.x + dx[d];
				int nextY = pos.y + dy[d];
				
				if (outOfRange(nextX, nextY) || copyBoard[nextX][nextY] != EMPTY) continue;
				copyBoard[nextX][nextY] = VIRUS;
				queue.offer(new Position(nextX, nextY));
			}
		}
	}
	
	public static int countEmpty(int[][] copyBoard) {
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyBoard[i][j] == EMPTY) result++;
			}
		}
		
		return result;
	}
	
	public static boolean outOfRange(int x, int y) {
		if (x < 0 || y < 0 || x == N || y == M) return true;
		return false;
	}
}
