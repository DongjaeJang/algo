package swea.d1.d1_2050;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] alphaList = br.readLine().toCharArray();
		int[] numList = new int[alphaList.length];
		
		int idx = 0;
		for (char alpha : alphaList) numList[idx++] = alpha - 'A' + 1;
		
		for (int i = 0; i < alphaList.length; i++) {
			System.out.printf("%d", numList[i]);
			if (i == alphaList.length - 1) System.out.println();
			else System.out.printf(" ");
		}
	}
}
