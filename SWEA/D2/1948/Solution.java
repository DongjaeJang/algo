package swea.d2.d2_1948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int[] month31 = { 1, 3, 5, 7, 8, 10, 12 };
		int[] month30 = { 4, 6, 9, 11 };
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int month_1 = Integer.parseInt(st.nextToken());
			int day_1 = Integer.parseInt(st.nextToken());
			int month_2 = Integer.parseInt(st.nextToken());
			int day_2 = Integer.parseInt(st.nextToken());
			
			int count = 0;
			if (month_1 == month_2) count = day_2 - day_1 + 1;
			else {
				if (contains(month31, month_1)) count += (31 - day_1 + 1);
				else if (contains(month30, month_1)) count += (30 - day_1 + 1);
				else count += (28 - day_1 + 1);
				month_1++;
				while (month_1 != month_2) {
					if (contains(month31, month_1)) count += 31;
					else if (contains(month30, month_1)) count += 30;
					else count += 28;
					month_1++;
				}
				count += day_2;
			}
			
			answer.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.println(answer);
	}
	

	private static boolean contains(int[] list, int num) {
		for (int i = 0; i < list.length; i++) {
			if (num == list[i])
				return true;
		}
		return false;
	}
}
