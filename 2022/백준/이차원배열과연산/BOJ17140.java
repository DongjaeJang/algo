package practice;

import java.io.*;
import java.util.*;

public class BOJ17140 {
	public static int r, c, k;
	public static int rowLength, colLength;
	public static int[][] board;
	
	public static class Info implements Comparable<Info> {
		int num;
		int count;
		
		public Info (int num, int count) {
			this.num = num;
			this.count = count;
		}
		
		public int compareTo(Info o) {
			if (this.count == o.count) return this.num - o.num;
			return this.count - o.count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
		k = Integer.parseInt(st.nextToken());
		
		board = new int[100][100];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		rowLength = 3; colLength = 3;
		
		int second = 0;
		
		while (true) {
			if (board[r][c] == k) break;
			if (second == 101) {
				System.out.println(-1);
				System.exit(0);
			}
			if (rowLength >= colLength) rowOperation();
			else colOperation();

			second++;
		}
		
		System.out.println(second);
	}
	
	public static void rowOperation() {
		int[][] tempBoard = new int[100][100];
		// 모든 행에 대해 숫자 카운팅
		for (int i = 0; i < rowLength; i++) {
			Map<Integer, Integer> hash = new HashMap<>();
			
			for (int j = 0; j < 100; j++) {
				int n = board[i][j];
				if (n == 0) continue;
				if (!hash.containsKey(n)) hash.put(n, 0);
				hash.put(n, hash.get(n) + 1);
			}
			List<Info> list = new ArrayList<>();
			
			for (int key : hash.keySet()) {
				list.add(new Info(key, hash.get(key)));
			}
			
			list.sort(null);
			
			colLength = Math.max(colLength, list.size() * 2);
			for (int j = 0; j < list.size(); j++) {
				if (j == 50) break;
				tempBoard[i][2 * j] = list.get(j).num;
				tempBoard[i][2 * j + 1] = list.get(j).count;
			}
		}
		// 길이 업데이트
		board = tempBoard;
	}
	
	public static void colOperation() {
		int[][] tempBoard = new int[100][100];
		// 모든 행에 대해 숫자 카운팅
		for (int j = 0; j < colLength; j++) {
			Map<Integer, Integer> hash = new HashMap<>();
			
			for (int i = 0; i < 100; i++) {
				int n = board[i][j];
				if (n == 0) continue;
				if (!hash.containsKey(n)) hash.put(n, 0);
				hash.put(n, hash.get(n) + 1);
			}
			List<Info> list = new ArrayList<>();
			
			for (int key : hash.keySet()) {
				list.add(new Info(key, hash.get(key)));
			}
			
			list.sort(null);
			rowLength = Math.max(rowLength, list.size() * 2);
			
			for (int i = 0; i < list.size(); i++) {
				if (i == 50) break;
				tempBoard[2 * i][j] = list.get(i).num;
				tempBoard[2 * i + 1][j] = list.get(i).count;
			}
		}
		// 길이 업데이트
		board = tempBoard;
	}
}
