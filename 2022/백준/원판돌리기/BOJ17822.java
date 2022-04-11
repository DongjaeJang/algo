package practice;

import java.io.*;
import java.util.*;

public class BOJ17822 {
	public static int N, M, T;
	public static List[] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		board = new List[N];
		for (int i = 0; i < N; i++) {
			board[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				board[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			moveBoard(x, d, k);
			checkBoard();
		}
		
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int n = (int)board[i].get(j);
				if (n == 0) continue;
				result += n;
			}
		}
		
		System.out.println(result);
	}
	
	public static void moveBoard (int x, int d, int k) {
		k %= M;
		
		while (k-- > 0) {
			if (d == 0) {
				for (int i = x; i <= N; i += x) {
					board[i - 1].add(0, board[i - 1].remove(M - 1));
				}
			}
			else {
				for (int i = x; i <= N; i += x) {
					board[i - 1].add(board[i - 1].remove(0));
				}
			}
		}
	}
	
	public static void checkBoard() {
		boolean flag = false;
		boolean[][] visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int n = (int)board[i].get(j);
				if (n == 0 || visited[i][j]) continue;

				Queue<int[]> queue = new LinkedList<>();
				List<int[]> posList = new ArrayList<>();
				
				queue.offer(new int[] {i, j, n});
				posList.add(new int[] {i, j});
				
				while (!queue.isEmpty()) {
					int[] pos = queue.poll();
					int x = pos[0];
					int y = pos[1];
					int value = pos[2];
					
					if (visited[x][y]) continue;
					visited[x][y] = true;
					
					// 좌
					int leftIdx = y == 0 ? M - 1 : y - 1;
					if (!visited[x][leftIdx] && (int)board[x].get(leftIdx) == value) {
						posList.add(new int[] {x, leftIdx});
						queue.offer(new int[] {x, leftIdx, value});
					}
					// 우
					int rightIdx = y == M - 1 ? 0 : y + 1;
					if (!visited[x][rightIdx] && (int)board[x].get(rightIdx) == value) {
						posList.add(new int[] {x, rightIdx});
						queue.offer(new int[] {x, rightIdx, value});
					}
					// 뒤
					int behindIdx = x + 1;
					if (behindIdx < N && !visited[behindIdx][y] && (int)board[behindIdx].get(y) == value) {
						posList.add(new int[] {behindIdx, y});
						queue.offer(new int[] {behindIdx, y, value});
					}
					// 앞
					int frontIdx = x - 1;
					if (frontIdx >= 0 && !visited[frontIdx][y] && (int)board[frontIdx].get(y) == value) {
						posList.add(new int[] {frontIdx, y});
						queue.offer(new int[] {frontIdx, y, value});
					}
				}
				
				if (posList.size() > 1) {
					flag = true;
					
					for (int z = 0; z < posList.size(); z++) {
						int[] pos = posList.get(z);
						board[pos[0]].set(pos[1], 0); 
					}
				}
			}
		}
		
		// 인접한 부분 하나도 못찾았을 때
		if (!flag) {
			int sum = 0;
			int count = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int n = (int)board[i].get(j);
					if (n == 0) continue;
					sum += n;
					count++;
				}
			}
			if (sum == 0) {
				System.out.println(0);
				System.exit(0);
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int n = (int)board[i].get(j);
					if (n == 0) continue;
					
					if (n * count > sum) {
						board[i].set(j, n - 1);
					} else if (n * count < sum){
						board[i].set(j, n + 1);
					}
				}
			}
		}
	}
}
