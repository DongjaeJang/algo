package day11;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] check = new int[N > 5 ? N + 1 : 6];
		Arrays.fill(check, N / 3 + 2);

		check[3] = 1; check[5] = 1;
		for (int i = 6; i <= N; i++) {
			check[i] = Math.min(check[i], check[i - 3] + 1);
			check[i] = Math.min(check[i], check[i - 5] + 1);
		}
		
		System.out.println(check[N] != N / 3 + 2 ? check[N] : -1);
	}
}
