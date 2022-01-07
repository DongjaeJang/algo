package swea.d2.d2_1946;

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
			answer.append("#").append(tc).append("\n");
			
			int N = Integer.parseInt(br.readLine());
			int index = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String letter = st.nextToken();
				int count = Integer.parseInt(st.nextToken());
				
				for (int j = 0; j < count; j++) {
					answer.append(letter);
					index++;
					if (index % 10 == 0) answer.append("\n");
				}
			}
			if (index % 10 != 0) answer.append("\n");
		}
		System.out.println(answer);
	}
}
