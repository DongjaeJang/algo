package swea.d2.d2_1970;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder answer = new StringBuilder();
		
		int[] coins = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int money = sc.nextInt();
			int[] used = new int[8];
			
			for (int j = 0; j < 8; j++) {
				used[j] += (money / coins[j]);
				money %= coins[j];
			}
			
			answer.append("#").append(i).append("\n");
			for (int j = 0; j < 8; j++) {
				answer.append(used[j]);
				if (j == 7) answer.append("\n");
				else answer.append(" ");
			}
		}
		System.out.println(answer);
	}
}
