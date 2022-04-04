package practice;

import java.io.*;
import java.util.*;

public class BOJ17143 {
	public static int R, C, M;
	public static int[][] board;
	public static List<Shark> sharks;
	
	public static int pos;
	public static int result;
	
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	
	public static class Shark implements Comparable<Shark> {
		int x, y;
		int speed;
		int dir;
		int size;

		public Shark (int x, int y, int speed, int dir, int size) {
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}

		@Override
		public int compareTo(Shark o) {
			return o.size - this.size;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[R][C];
		
		sharks = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken()) - 1;
			int size = Integer.parseInt(st.nextToken());
			
			speed %= (2 * (dir < 2 ? R : C) - 2);
			
			board[x][y] = size;
			sharks.add(new Shark(x, y, speed, dir, size));
		}
		
		sharks.sort(null);
		
		pos = -1; result = 0;
		
		while (++pos < C) {	// 1. 어부 이동
			// 2. 상어 잡기
			catchShark();
			// 3. 상어 이동
			moveShark();
		}
		
		System.out.println(result);
	}
	
	public static void catchShark() {
		for (int i = 0; i < R; i++) {
			if (board[i][pos] != 0) {
				// 크기
				int size = board[i][pos];
				result += size;
				
				// 리스트에서 삭제
				for (int j = 0; j < sharks.size(); j++) {
					if (sharks.get(j).size == size) {
						sharks.remove(j);
						break;
					}
				}
				
				// 보드에서 삭제
				board[i][pos] = 0;
				break;
			}
		}
	}
	
	public static void moveShark() {
		List<Integer> removeIndices = new ArrayList<>();
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				board[i][j] = 0;
			}
		}
		
		for (int i = 0; i < sharks.size(); i++) {
			Shark currentShark = sharks.get(i);
			
			int x = currentShark.x;
			int y = currentShark.y;
			int speed = currentShark.speed;
			int dir = currentShark.dir;
			int size = currentShark.size;
			
			for (int j = 0; j < speed; j++) {
				int nextX = x + dx[dir];
				int nextY = y + dy[dir];
				
				if (outOfRange(nextX, nextY)) {
					if (dir % 2 == 0) dir += 1;
					else dir -= 1;
					
					nextX = x + dx[dir];
					nextY = y + dy[dir];
				}
				x = nextX; y = nextY;
			}
			
			if (board[x][y] != 0) {
				removeIndices.add(i);
				continue;
			}
			board[x][y] = size;
			sharks.get(i).x = x;
			sharks.get(i).y = y;
			sharks.get(i).dir = dir;
		}
		
		for (int i = removeIndices.size() - 1; i >= 0; i--) {
			int idx = removeIndices.get(i);
			sharks.remove(idx);
		}
	}
	
	public static boolean outOfRange(int x, int y) {
		if (x < 0 || x == R || y < 0 || y == C) return true;
		return false;
	}
}
