package swea.d2.d2_1285;

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
			int N = Integer.parseInt(br.readLine());
			int count = 0;
			int value = 100001;
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				int current = Integer.parseInt(st.nextToken());
				if (Math.abs(current) < value) {
					value = Math.abs(current);
					count = 1;
				} else if (Math.abs(current) == value) {
					count++;
				}
			}
			
			answer.append("#").append(tc).append(" ").append(value).append(" ").append(count).append("\n");
		}
		
		System.out.println(answer);
	}
}
