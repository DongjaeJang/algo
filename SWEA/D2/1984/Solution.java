package swea.d2.d2_1984;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testNum = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= testNum; tc++) {
			String[] numList = br.readLine().split(" ");
			int max = -1;
			int min = 10001;
			int sum = 0;
			
			for (String num : numList) {
				int n = Integer.parseInt(num);
				if (max < n) max = n;
				if (min > n) min = n;
				sum += n;
			}
			
			System.out.printf("#%d %d%n", tc, (int)(Math.round((sum - max - min) / 8.)));
		}
	}
}
