package swea.d3.d3_10965;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		int MAX_NUMBER = 10000001;
		boolean[] checkPrimes = new boolean[MAX_NUMBER];
		List<Integer> primes = new ArrayList<>();

		int sqrtMAX = (int) Math.sqrt(MAX_NUMBER - 1);
		for (int i = 2; i <= sqrtMAX; i++) {
			if (checkPrimes[i])
				continue;
			else
				primes.add(i);
			for (int j = i + i; j <= sqrtMAX; j += i)
				checkPrimes[j] = true;
		}
		int primesSu = primes.size();

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());

			int result = 1;
			for (int i = 0; i < primesSu; i++) {
				int current = primes.get(i);
				int count = 0;
				while (n % current == 0) {
					n /= current;
					count++;
				}
				if (count % 2 == 1) result *= current;
				if (n == 1 || n < current) break;
			}
			if (n > 1) result *= n;
			
			answer.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(answer);
	}
}
