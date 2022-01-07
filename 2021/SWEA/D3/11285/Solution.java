package swea.d3.d3_11285;

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
			int sum = 0;
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				double target = Math.sqrt(Math.pow(Math.abs(x), 2) + Math.pow(Math.abs(y), 2));
				for (int p = 10; p > 0; p--) {
					double r = 20 * (11 - p);
					if (target <= r) {
						sum += p;
						break;
					}
				}
			}
			answer.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.println(answer);
	}
}
