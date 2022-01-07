package swea.d2.d2_1859;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testNum = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= testNum; tc++) {
			int infoNum = Integer.parseInt(br.readLine());
			long[] priceInfo = new long[infoNum];
			
			String[] info = br.readLine().split(" ");
			for (int i = 0; i < info.length; i++) priceInfo[i] = Integer.parseInt(info[i]);
			
			
			long benefit = 0;
			int itemCount = 0;
			int i = 0;
			long tempMax = -1;
			
			while (i < priceInfo.length) {
				tempMax = findMax(priceInfo, i);
				for (int j = i; j < priceInfo.length; j++) {
					if (priceInfo[j] < tempMax) itemCount++;
					else {
						while (itemCount > 0) {
							benefit += (priceInfo[j] - priceInfo[j-itemCount]);
							itemCount--;
						}
						i = j+1;
						break;
					}
				}
			}
			
			System.out.printf("#%d %d%n", tc, benefit);
		}
	}
	
	private static long findMax(long[] priceInfo, int index) {
		long max = -1;
		for (int i = index; i < priceInfo.length; i++) {
			if (priceInfo[i] > max) max = priceInfo[i];
		}
		return max;
	}
}
