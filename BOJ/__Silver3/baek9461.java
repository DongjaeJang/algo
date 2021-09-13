package boj_self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ9461 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		long [] array = new long[101];
		array[1] = array[2] = array[3] = 1;
		array[4] = array[5] = 2;
		
		for (int i = 6; i <= 100; i++) array[i] = array[i - 1] + array[i - 5];
		
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			answer.append(array[N]).append("\n");
		}
		System.out.println(answer);
	}
}
