package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Temp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int answer = 0;
		
		int N = Integer.parseInt(br.readLine());
		int sqrtN = (int)Math.sqrt(N);
		
		for (int i = 1; i <= sqrtN; i++) {
			int temp = i;
			while (i * temp <= N) {
				answer++;
				temp++;
			}
		}
		System.out.println(answer);
	}
}
