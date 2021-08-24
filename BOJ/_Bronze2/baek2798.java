package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Temp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[] list = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) list[i] = Integer.parseInt(st.nextToken());

		int result = 0;
		for (int i = 0; i < N - 2; i++) {
			int sum = list[i];
			if (sum > M) continue;
			for (int j = i + 1; j < N - 1; j++) {
				if (sum + list[j] > M) continue;
				int sum2 = sum + list[j];
				for (int k = j + 1; k < N; k++) {
					if (sum2 + list[k] > M) continue;
					result = Math.max(result, sum2 + list[k]);
				}
			}
		}
		System.out.println(result);
	}
}
