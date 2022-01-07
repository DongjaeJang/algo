package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Temp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		 
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(numbers);
		
		long min = 1;
		long max = numbers[N - 1];
		
		while (min <= max) {
			long count = 0;
			
			long mid = (min + max) / 2;
			
			for (int i = 0; i < N; i++) count += numbers[i] / mid;
			
			if (count >= K) min = mid + 1;
			else max = mid - 1;
		}
		
		System.out.println(max);
	}
}
