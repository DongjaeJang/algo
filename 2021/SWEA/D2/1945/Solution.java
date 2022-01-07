package swea.d2.d2_1945;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		int[] numList = {11, 7, 5, 3, 2};
		for (int tc = 1; tc <= T; tc++) {
			int[] countList = new int[5];
			int target = Integer.parseInt(br.readLine());
			
			int index = 0;
			while (target != 1) {
				if (target % numList[index] != 0) {
					index++;
					continue;
				}
				int divider = numList[index];
				
				target /= divider;
				countList[index]++;
			}
			answer.append("#").append(tc);
			for (int i = 4; i >= 0; i--) {
				answer.append(" ").append(countList[i]);
			}
			answer.append("\n");
		}
		System.out.println(answer);
	}
}
