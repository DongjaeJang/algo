package swea.d2.d2_1989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testNum = Integer.parseInt(br.readLine());

		for (int i = 1; i <= testNum; i++) {
			String str = br.readLine();
			int len = str.length();
			int halfLen = len / 2;

			if (len % 2 == 0)
				System.out.printf("#%d %d%n", i, str.substring(0, halfLen).equals(new StringBuffer(str.substring(halfLen)).reverse().toString()) ? 1 : 0);
			else 
				System.out.printf("#%d %d%n", i, str.substring(0, halfLen).equals(new StringBuffer(str.substring(halfLen+1)).reverse().toString()) ? 1 : 0);
		}
	}
}
