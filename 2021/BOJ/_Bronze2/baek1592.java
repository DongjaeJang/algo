package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Temp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
		
		int[] numbers = new int[N];
		
		int answer = 0, current = 0;
		
		while (true) {
			numbers[current]++;
			if (numbers[current] == M) break;

			answer++;
			if (numbers[current] % 2 == 1) current += L;
			else current -= L;
			
			if (current >= N) current %= N;
			else if (current < 0) current += N;
		}
		
		System.out.println(answer);
	}
}
