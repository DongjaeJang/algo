package swea.d1.d1_2019;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for (int i = 0; i <= n; i++) 
			if (i == n) System.out.println((int)Math.pow(2, i)); 
			else System.out.printf("%d ", (int)Math.pow(2, i));
	}
}
