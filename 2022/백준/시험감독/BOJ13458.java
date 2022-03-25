package practice;

import java.io.*;
import java.util.*;

public class BOJ13458 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] classes = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) classes[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		long result = 0;
		
		for (int i = 0; i < N; i++) {
			int total = classes[i];
			
			result++;
			total -= a;
			if (total <= 0) continue;
			result += (total % b == 0) ? total / b : total / b + 1;
		}
		
		System.out.println(result);
	}
}
