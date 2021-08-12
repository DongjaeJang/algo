package swea.d3.d3_10726;

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
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			boolean flag = true;
			for (int i = 0; i < N; i++) {
				if ((M & (1 << i)) == 0) {
					flag = false;
					break;
				}
			}
			answer.append("#").append(tc).append(" ").append(flag ? "ON" : "OFF").append("\n");
		}
		System.out.println(answer);
	}
}
