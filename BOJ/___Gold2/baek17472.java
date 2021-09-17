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

public class Main2 {
	public static class Position implements Comparable<Position>{
		int x;
		int y;
		int weight;
		
		public Position (int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Position [x=" + x + ", y=" + y + ", w=" + weight + "]";
		}

		@Override
		public int compareTo(Position o) {
			return this.weight - o.weight;
		}
	}
	
	static int N, M;
	static int[][] board;
	static List<Position>[] islandPositions;
	static List<Position> islandDistances;
	static int islandCount;

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 맵에 있는 섬 인덱스 붙이고, 인덱스 별 위치 잡기
		updateIslandIndex();
		
		// 섬간 최소거리 찾기
		updateIslandDistance();
		
		// 최소 스패닝
		findMinimum();
	}
	
	public static void findMinimum() {
		int[] parents = new int[islandCount + 1];
		for (int i = 1; i <= islandCount; i++) parents[i] = i;
		
		int count = 0, result = 0;
		for (int i = 0; i < islandDistances.size(); i++) {
			Position current = islandDistances.get(i);
			
			if (unionParent(parents, current.x, current.y)) {
				result += current.weight;
				count++;
				
				if (count == islandCount - 1) {
					System.out.println(result);
					System.exit(0);
				}
			}
		}
		
		System.out.println(-1);
	}
	
	public static void updateIslandDistance() {
		islandDistances = new ArrayList<Position>();
		
		for (int i = 1; i <= islandCount; i++) {
			for (int j = 0; j < islandPositions[i].size(); j++) {
				Position current = islandPositions[i].get(j);
				
				for (int d = 0; d < 4; d++) {
					int nextX = current.x + dx[d];
					int nextY = current.y + dy[d];
					
					if (outOfRange(N, M, nextX, nextY) || board[nextX][nextY] != 0) continue;
					
					while (true) {
						nextX += dx[d];
						nextY += dy[d];
						
						if (outOfRange(N, M, nextX, nextY) || board[nextX][nextY] == i) break;
						if (board[nextX][nextY] != 0) {
							int dist = Math.abs(current.x - nextX) + Math.abs(current.y - nextY) - 1;
							if (dist > 1) islandDistances.add(new Position(i, board[nextX][nextY], dist));
							
							break;
						}
					}
				}
			}
		}
		
		islandDistances.sort(null);
	}
	
	public static void updateIslandIndex() {
		int index = 1;
		boolean[][] checked = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1 && !checked[i][j]) {
					Queue<Position> queue = new LinkedList<>();
					queue.add(new Position(i, j, 0));
					while (!queue.isEmpty()) {
						Position current = queue.poll();
						checked[current.x][current.y] = true;
						board[current.x][current.y] = index;
						
						for (int d = 0; d < 4; d++) {
							int nextX = current.x + dx[d];
							int nextY = current.y + dy[d];
							
							if (outOfRange(N, M, nextX, nextY) || board[nextX][nextY] != 1 ||checked[nextX][nextY]) continue;
							queue.offer(new Position(nextX, nextY, 0));
						}
					}
					index++;
				}
			}
		}
		
		islandCount = index - 1;
		islandPositions = new ArrayList[islandCount + 1];
		
		for (int i = 1; i <= islandCount; i++) islandPositions[i] = new ArrayList<Position>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] != 0) islandPositions[board[i][j]].add(new Position(i, j, 0));
			}
		}
	}
	
	public static boolean outOfRange(int N, int M, int x, int y) {
		if (x < 0 || y < 0 || x == N || y == M) return true;
		return false;
	}
	
	public static int findParent(int[] parents, int x) {
		if (parents[x] != x) return parents[x] = findParent(parents, parents[x]);
		return x;
	}
	
	public static boolean unionParent(int[] parents, int a, int b) {
		int ap = findParent(parents, a);
		int bp = findParent(parents, b);
		
		if(ap == bp) return false;
		
		else {
			if(ap <= bp) parents[ap] = bp; 
			else parents[bp] = ap;
			
			return true;
		}
	}
}
