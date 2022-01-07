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
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int[] targets = new int[M];
		for (int i = 0; i < M; i++) targets[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(numbers);
		
		for (int target : targets) {
			answer.append(binarySearch(numbers, target)).append("\n");
		}
		
		System.out.println(answer);
	}
	
	private static int binarySearch(int[] numbers, int target) {
		int start = 0;
		int end = numbers.length - 1;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			
			if (numbers[mid] == target) return 1;
			else if (numbers[mid] > target) end = mid - 1;
			else start = mid + 1;
		}
		
		return 0;
	}
}
