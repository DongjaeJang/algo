package practice;

import java.io.*;
import java.util.*;

public class BOJ14888 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
		
		Set<String> operandSet = new HashSet<>();
		
		int[] array = new int[N - 1];
		int idx = 0;
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 4; i++) {
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) array[idx++] = i;
		}
		
		do {
			StringBuilder str = new StringBuilder();
			for (int i = 0; i < N - 1; i++) str.append(array[i]);
			
			operandSet.add(str.toString());
		} while (nextPermutation(array));
		
		Iterator<String> iter = operandSet.iterator();
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		while (iter.hasNext()) {
			String str = iter.next();
			
			char[] ops = str.toCharArray();
			int result = numbers[0];
			
			for (int i = 0; i < N - 1; i++) {
				char op = ops[i];
				int next = numbers[i + 1];
				
				if (op == '0') result += next;
				else if (op == '1') result -= next;
				else if (op == '2') result *= next;
				else {
					if (result >= 0) result /= next;
					else {
						result *= -1;
						result /= next;
						result *= -1;
					}
				}
			}
			
			max = Math.max(max, result);
			min = Math.min(min, result);
		}
		
		answer.append(max).append("\n").append(min);
		System.out.println(answer);
	}

	private static boolean nextPermutation(int[] array) {
		int N = array.length;
		
		int i = N - 1;
		while (i > 0 && array[i - 1] >= array[i]) --i;
		if (i == 0) return false;
		
		int j = N - 1;
		while (array[i - 1] >= array[j]) --j;
		swap(array, i - 1, j);
		
		int k = N - 1;
		while (i < k) swap(array, i++, k--);
		return true;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
