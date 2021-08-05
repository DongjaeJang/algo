package swea.d2.d2_2005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= testNum; tc++) {
			int num = Integer.parseInt(br.readLine());
			int[][] map = new int[num][num];
			for (int i = 0; i < num; i++) {
				for (int j = 0; j <= i; j++) {
					if (j == 0 || j == i) map[i][j] = 1;
					else map[i][j] = map[i-1][j-1] + map[i-1][j];
				}
			}
			System.out.println("#"+tc);
			for (int i = 0; i < num; i++) {
				for (int j = 0; j <= i; j++) {
					if (i == j) System.out.println(map[i][j]);
					else System.out.printf("%d ", map[i][j]);
				}
			}
		}
	}
}
