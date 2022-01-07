package swea.d1.d1_2029;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.printf("#%d %d %d%n", i, a/b, a%b);
		}
	}
}
