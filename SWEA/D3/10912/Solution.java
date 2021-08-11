package swea.d3.d3_10912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			char[] charStr = br.readLine().toCharArray();
			int[] frequency = new int[27];
			for (char c : charStr) {
				frequency[c - 'a']++;
			}
			
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < frequency.length; i++) if (frequency[i] % 2 == 1) result.append((char)(i + 'a'));
			
			answer.append("#").append(tc).append(" ").append(result.length() != 0 ? result : "Good").append("\n");
		}
		System.out.println(answer);
	}
}
