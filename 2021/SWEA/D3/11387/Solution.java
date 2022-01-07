package swea.d3.d3_11387;

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
			int attack = Integer.parseInt(st.nextToken());
			int Lpercent = Integer.parseInt(st.nextToken());
			int total = Integer.parseInt(st.nextToken());
			int count = 0;
			
			int result = 0;
			while (count < total) {
				result += attack + attack * count * Lpercent / 100;
				count++;
			}
			
			
			answer.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(answer);
	}
}
