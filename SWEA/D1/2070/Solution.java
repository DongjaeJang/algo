package swea.d1.d1_2070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testNum = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= testNum; i++) {
			String[] numInfo = br.readLine().split(" ");
			char c = 0;
			int num1 = Integer.parseInt(numInfo[0]);
			int num2 = Integer.parseInt(numInfo[1]);
			
			if (num1 > num2) c = '>';
			else if (num1 < num2) c = '<';
			else c = '=';
			
			System.out.printf("#%d %c%n", i, c);
		}
	}
}
