package swea.d2.d2_1204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			br.readLine();
			st = new StringTokenizer(br.readLine(), " ");
			int[] frequency = new int[101];
			while (st.hasMoreTokens()) {
				frequency[Integer.parseInt(st.nextToken())]++;
			}
			int maxFrequency = -1;
			int maxScore = 0;
			
			for (int i = 0; i < 100; i++) {
				if (maxFrequency <= frequency[i]) {
					maxFrequency = frequency[i];
					maxScore = i;
				}
			}
			answer.append("#").append(tc).append(" ").append(maxScore).append("\n");
		}
		System.out.println(answer);
	}
}
