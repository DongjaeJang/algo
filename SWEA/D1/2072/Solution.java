package swea.d1.d1_2072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= t; i++) {
			int sum = 0;
			String[] numList = br.readLine().split(" ");
			for (String num : numList) {
				if (Integer.parseInt(num) % 2 == 1) sum += Integer.parseInt(num);
			}
			System.out.printf("#%d %d%n", i, sum);
		}
	}
}
