package swea.d3.d3_9940;

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
			int n = Integer.parseInt(br.readLine());
			boolean[] checked = new boolean[n + 1];
			
			boolean flag = true;
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= n; i++) {
				int current = Integer.parseInt(st.nextToken());
				if (checked[current]) {
					flag = false;
					break;
				} else checked[current] = true;
			}
			
			answer.append("#").append(tc).append(" ").append(flag ? "Yes" : "No");
			if (tc < T)
				answer.append("\n");
		}
		System.out.println(answer);
	}
}
