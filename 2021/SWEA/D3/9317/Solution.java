package swea.d3.d3_9317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			char[] A = br.readLine().toCharArray();
			char[] B = br.readLine().toCharArray();
			
			int count = 0;
			for (int i = 0; i < N; i++) if (A[i] == B[i]) count++;
			
			answer.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.println(answer);
	}
}
