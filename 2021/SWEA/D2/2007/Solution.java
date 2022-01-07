package swea.d2.d2_2007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testNum = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= testNum; tc++) {
			String str = br.readLine();
			String temp = "";
			
			for (int i = 1; i < str.length(); i++) {
				temp = str.substring(0, i);
				String nextTemp = str.substring(i, 2*i);
				if (temp.equals(nextTemp)) {
					System.out.printf("#%d %d%n", tc, temp.length());
					break;
				}
			}
		}
	}
}
