package swea.d1.d1_2056;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testNum = Integer.parseInt(br.readLine());
		int[] month31 = { 1, 3, 5, 7, 8, 10, 12 };
		int[] month30 = { 4, 6, 9, 11 };

		for (int i = 1; i <= testNum; i++) {

			String str = br.readLine();

			String year = str.substring(0, 4);
			String month = str.substring(4, 6);
			String day = str.substring(6, 8);
			
            boolean flag = true;
			if (Integer.parseInt(month) > 12 || month.equals("00") || day.equals("00")) {
				flag = false;
			} else if (contains(month31, Integer.parseInt(month))) {
				if (Integer.parseInt(day) > 31) 
					flag = false;
			} else if (contains(month30, Integer.parseInt(month))) {
				if (Integer.parseInt(day) > 30) 
					flag = false;
			} else if (month.equals("02")) {
				if (Integer.parseInt(day) > 28)
					flag = false;
			} 
            
            if (flag) System.out.printf("#%d %s%n", i, year + "/" + month + "/" + day);
			else System.out.printf("#%d %d%n", i, -1);
		}
	}

	private static boolean contains(int[] list, int num) {
		for (int i = 0; i < list.length; i++) {
			if (num == list[i])
				return true;
		}
		return false;
	}
}

