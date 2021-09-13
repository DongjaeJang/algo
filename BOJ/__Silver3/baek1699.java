package boj_self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1699 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int MAX_NUM = (int)1e5 + 1;
		int N = Integer.parseInt(br.readLine());
		
		int[] array = new int[N + 1];
		Arrays.fill(array, MAX_NUM);
		array[0] = 0; array[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= Math.sqrt(i); j++) {
				array[i] = Math.min(array[i], array[i - (int)Math.pow(j, 2)] + 1);
			}
		}
		int[] t = new int[N + 1];
		for (int i = 0; i <= N; i++) t[i] = i;
		
		System.out.println(array[N]);
	}
}
