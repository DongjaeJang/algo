package swea.d3.d3_12004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			boolean flag = false;
			int num = Integer.parseInt(br.readLine());
			for (int a = 1; a < 10; a++) {
				for (int b = 1; b < 10; b++) {
					if (a*b == num) {
						flag = true;
						break;
					}
				}
			}
			answer.append("#").append(i).append(" ").append(flag ? "Yes" : "No").append("\n");
		}
		System.out.println(answer);
	}
}
