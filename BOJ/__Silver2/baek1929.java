package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Temp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
		boolean[] checkPrime = new boolean[B + 1];
		Arrays.fill(checkPrime, true);
		checkPrime[1] = false;
		
		for (int i = 2; i <= B; i++) {
			if (checkPrime[i]) {
				for (int j = i + i; j <= B; j += i) checkPrime[j] = false;
			}
		}
		
		for (int i = A; i <= B; i++) if (checkPrime[i]) answer.append(i).append("\n");
		
		System.out.println(answer);
	}
}
