package swea.d3.d3_9700;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder answer = new StringBuilder();
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			double p = sc.nextDouble();
			double q = sc.nextDouble();
			
			double s1 = (1 - p) * q;
			double s2 = p * (1 - q) * q;
			
			answer.append("#").append(tc).append(" ").append(s1 < s2 ? "YES" : "NO").append("\n");
		}
		System.out.println(answer);
	}
}
