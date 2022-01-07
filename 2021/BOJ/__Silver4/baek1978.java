package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Temp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		boolean[] primes = new boolean[1001];
		Arrays.fill(primes, true);
		primes[1] = false;
		
		for (int i = 2; i <= 1000; i++) {
			if (primes[i]) {
				for (int j = i + i; j < 1001; j += i) {
					if (primes[j]) {
						primes[j] = false;
					}
				}
			}
		}
		
		int count = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (primes[num]) count++;
		}
		
		System.out.println(count);
	}
}
