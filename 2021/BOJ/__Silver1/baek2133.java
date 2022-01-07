package boj_self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2133 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] array = new int[N + 1];
		if (N == 1) System.out.println(0);
		else {
			array[2] = 3;
			
			for (int i = 4; i <= N; i++) {
				if (i % 2 == 0) {
					array[i] += array[i - 2] * 3;
					for (int j = i - 4; j >= 0; j -= 2) array[i] += array[j] * 2;
					array[i] += 2;
				} 
			}
			System.out.println(array[N]);
		}
	}
}
