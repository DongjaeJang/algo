package practice;

import java.io.*;
import java.util.*;

public class BOJ14888_2 {
	public static int N;
	public static int max, min;
	
	public static int[] numbers, operands;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
		
		operands = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) operands[i] = Integer.parseInt(st.nextToken());
		
		max = Integer.MIN_VALUE; min = Integer.MAX_VALUE;
		dfs(numbers[0], 1);
		
		answer.append(max).append("\n").append(min);
		System.out.println(answer);
	}

	private static void dfs(int num, int idx) {
		if (idx == N) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (operands[i] == 0) continue;
			
			operands[i]--;
			if (i == 0) dfs(num + numbers[idx], idx + 1);
			else if (i == 1) dfs(num - numbers[idx], idx + 1);
			else if (i == 2) dfs(num * numbers[idx], idx + 1);
			else dfs(num / numbers[idx], idx + 1);
			operands[i]++;
		}
	}
}
