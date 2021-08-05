package swea.d2.d2_1926;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String[] strList = new String[n];
		for (int i = 1; i <= n; i++) {
			strList[i-1] = change369(Integer.toString(i));
		}
		System.out.println(String.join(" ", strList));
	}
	
	private static String change369(String str) {
		if (str.contains("3") || str.contains("6") || str.contains("9")) {
			String tempStr = "";
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '3' || str.charAt(i) == '6' || str.charAt(i) == '9') tempStr += "-";
			}
			return tempStr;
		} else {
			return str;
		}
	}
}
