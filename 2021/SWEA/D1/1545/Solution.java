package swea.d1.d1_1545;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = n; i >= 0; i--) {
			if (i == 0) System.out.println(0);
			else System.out.printf("%d ", i);
		}
	}
}
