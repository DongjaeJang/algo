package swea.d2.d2_1288;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			boolean[] isShowed = new boolean[10];
			int count = 0;
			
			int changeN = N;
			while (true) {
				char[] temp = (changeN + "").toCharArray();
				for (int j = 0; j < temp.length; j++) {
					if (isShowed[temp[j] - '0']) continue;
					else {
						isShowed[temp[j] - '0'] = true;
						count++;
					}
				}
				if (count == 10) break;
				changeN += N;
			}
			System.out.printf("#%d %d%n", tc, changeN);
		}
		
	}
}
