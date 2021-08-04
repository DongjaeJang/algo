package swea.d1.d1_1936;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		final int S = 1;
		final int R = 2;
		final int P = 3;

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		if ((a == S && b == P) || (a == R && b == S) || (a == P && b == R)) System.out.println("A");
		else if ((a == P && b == S) || (a == S && b == R) || (a == R && b == P)) System.out.println("B");
	}
}
