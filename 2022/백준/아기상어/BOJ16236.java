package practice;

import java.io.*;
import java.util.*;

public class BOJ16236 {
	public static int N;
	public static int fishCount;
	public static int[][] board;

	public static Shark shark;
	public static List<Fish> fishList;

	public static int second;

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static class Fish implements Comparable<Fish> {
		int x, y;
		int size;
		int dist;

		public Fish(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}

		public int compareTo(Fish o) {
			if (this.dist == o.dist) {
				if (this.x == o.x) {
					return this.y - o.y;
				}
				return this.x - o.x;
			}
			return this.dist - o.dist;
		}
	}

	public static class Shark extends Fish {
		int count;

		public Shark(int x, int y, int size) {
			super(x, y, size);
			this.count = 0;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		fishList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				board[i][j] = n;
				if (n == 0)
					continue;
				else if (n == 9)
					shark = new Shark(i, j, 2);
				else
					fishList.add(new Fish(i, j, n));
			}
		}
		fishCount = fishList.size();
		board[shark.x][shark.y] = 0;

		second = 0;
		while (fishCount > 0) {
			updateDist(); // 현재 상어에서 물고기들 거리 찾기
			eatFish();	// 물고기 먹기
		}

		System.out.println(second);
	}

	public static void updateDist() {
		int[][] distBoard = new int[N][N];
		boolean[][] visited = new boolean[N][N];

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { shark.x, shark.y, 0 });

		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			int x = pos[0];
			int y = pos[1];
			int dist = pos[2];

			if (visited[x][y])
				continue;
			visited[x][y] = true;
			distBoard[x][y] = dist;

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (outOfRange(nx, ny) || board[nx][ny] > shark.size)
					continue;
				queue.offer(new int[] { nx, ny, dist + 1 });
			}
		}

		for (int i = 0; i < fishCount; i++) {
			Fish fish = fishList.get(i);
			int dist = distBoard[fish.x][fish.y];

			if (board[fish.x][fish.y] >= shark.size || dist == 0)
				dist = Integer.MAX_VALUE;

			fishList.get(i).dist = dist;
		}

		fishList.sort(null);
	}

	public static void eatFish() {
		Fish fish = fishList.remove(0);
		if (fish.dist == Integer.MAX_VALUE) {
			System.out.println(second);
			System.exit(0);
		}
		
		board[fish.x][fish.y] = 0;
		shark.x = fish.x;
		shark.y = fish.y;
		second += fish.dist;

		shark.count++;
		if (shark.count == shark.size) {
			shark.count = 0;
			shark.size++;
		}

		fishCount--;
	}

	public static boolean outOfRange(int x, int y) {
		if (x < 0 || y < 0 || x == N || y == N)
			return true;
		return false;
	}
}
