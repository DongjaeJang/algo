package day14;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("/Users/dj/Desktop/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] weights = new int[N];
			for (int i = 0; i < N; i++) weights[i] = Integer.parseInt(st.nextToken());
			
			boolean[] isSelected = new boolean[N];
			result = 0;
			permutation(N, weights, isSelected, 0, 0, 0);
			answer.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(answer);
	}
	
	public static void permutation(int N, int[] weights, boolean[] isSelected, int left, int right, int count) {
		if (count == N) {
			result++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) continue;
			isSelected[i] = true;
			permutation(N, weights, isSelected, left + weights[i], right, count + 1);	// 왼쪽은 막 넣어도 괜찮음
			if (left >= right + weights[i])	// 오른쪽에 넣어줄때는 체크
				permutation(N, weights, isSelected, left, right + weights[i], count + 1);
			isSelected[i] = false;
		}
	}
}
