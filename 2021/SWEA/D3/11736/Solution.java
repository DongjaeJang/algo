package swea.d3.d3_11736;

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
			st = new StringTokenizer(br.readLine(), " ");
			
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			
			int count = 0;
			for (int i = 1; i < n-1; i++) {
				int before = array[i-1];
				int current = array[i];
				int after = array[i+1];
				
				if (current > before && current > after) continue;
				if (current < before && current < after) continue;
				count++;
			}
			answer.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.println(answer);
	}
}
