package day28;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static class Brick {
		int x, y, num;
		
		public Brick (int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
	public static int N, W, H;
	
	public static int[][] board;
	public static int[][] copyBoard;
	public static List<Integer> array = new ArrayList<>();
	
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("/Users/dj/Desktop/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			board = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			
			result = Integer.MAX_VALUE;
			
			permutation(0);
			
			answer.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(answer);
	}
	
	private static int countBricks() {
		int count = 0;
		for (int i = 0; i < H; i++) for (int j = 0; j < W; j++) if (copyBoard[i][j] != 0) count++;
		return count;
	}

	public static void downBricks() {
		for (int i = 0; i < W; i++) {
			for (int j = H - 1; j >= 0; j--) {
				if (copyBoard[j][i] == 0) {
					int k = j - 1;
					while(k >= 0) {
						if(copyBoard[k][i] != 0) { 
							copyBoard[j][i] = copyBoard[k][i]; 
							copyBoard[k][i] = 0; 
							break;
						}
						k--;
					}
					if(k == -1) break;
				}
			}
		}
	}
	
	public static void removeBricks(int col) {
		int idx = findRowIdx(col);
		if (idx == -1) return;
		
		Queue<Brick> queue = new LinkedList<Brick>();
		queue.add(new Brick(idx, col, copyBoard[idx][col] - 1));
		copyBoard[idx][col] = 0;
		
		while(queue.size()!=0) {
			Brick current = queue.poll();
			int x = current.x;
			int y = current.y;
			int num = current.num;
				
			for (int k = 0; k < 4; k++) {
				for (int n = 1; n <= num; n++) {
					int nextX = x + dx[k] * n;
					int nextY = y + dy[k] * n;
					
					if(outOfRange(nextX, nextY)) break;
					if(copyBoard[nextX][nextY] == 0) continue;
					queue.add(new Brick(nextX, nextY, copyBoard[nextX][nextY] - 1));
					copyBoard[nextX][nextY]=0;	
				}
			}
		}
	}
	
	public static int findRowIdx(int col) {
		for (int i = 0; i < H; i++) {
			if (copyBoard[i][col] != 0) return i;
		}
		return -1;
	}
	
	public static boolean outOfRange(int x, int y) {
		if (x < 0 || y < 0 || x >= H || y >= W) return true;
		return false;
	}
	
	private static void permutation(int cnt) {
		if(cnt == N) {
			copyBoard = new int[H][W];
			for (int i = 0; i < H; i++) copyBoard[i] = Arrays.copyOf(board[i], W);
			
			for (int i = 0; i < N; i++) {
				removeBricks(array.get(i));
				downBricks();
			}
			result = Math.min(result, countBricks());
			return;
		}
		
		for (int i = 0; i < W; i++) {
			array.add(i);
			permutation(cnt + 1);
			array.remove(array.size() - 1);
		}
		
	}
}
