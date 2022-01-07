package swea.d1.d1_2068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testNum = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= testNum; i++) {
			int max = -1;
			String[] numList = br.readLine().split(" ");
			for (String num : numList) {
				max = Math.max(max, Integer.parseInt(num));
			}
			System.out.printf("#%d %d%n", i, max);
		}
	}
}
