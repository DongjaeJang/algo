package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Temp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int[] cakes = new int[L + 1];
		
		int result = -1, resultPerson = -1, predict = -1, predictPerson = -1;
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			int count = 0;
			for (int j = start; j <= end; j++) {
				if (cakes[j] == 0) {
					count++;
					cakes[j] = i;
				}
			}
			
			if (predict < end - start) {
				predict = end - start;
				predictPerson = i;
			}
			
			if (count > result) {
				result = count;
				resultPerson = i;
			}
		}
		
		System.out.println(predictPerson);
		System.out.println(resultPerson);
	}
}
