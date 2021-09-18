package boj_self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2609 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
		
		int big = Math.max(A, B);
		int small = Math.min(A, B);
		
		int gcd = 1;
		for (int i = small; i > 0; i--) {
			if (A % i == 0 && B % i == 0) {
				gcd = i;
				break;
			}
		}
		int lcm = 1;
		for (int i = big; i <= A * B; i++) {
			if (i % A == 0 && i % B == 0) {
				lcm = i;
				break;
			}
		}

		System.out.println(gcd);
		System.out.println(lcm);
	}
}
