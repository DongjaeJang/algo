package swea.d2.d2_1986;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int tc = 1; tc <= n; tc++) {
			int num = sc.nextInt();
			int sum = 0;
			for (int i = 1; i <= num; i++) if (i % 2 == 0) sum -= i; else sum +=i;
			System.out.printf("#%d %d%n", tc, sum);
		}
	}
}
