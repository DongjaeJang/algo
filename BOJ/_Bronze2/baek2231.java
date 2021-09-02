package ajaxtest;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int target = sc.nextInt();
		
		int start = 0;
		
		int result = 0;
		while (start <= target) {
			int temp = start;
			String strStart = String.valueOf(start);
			for (int i = 0; i < strStart.length(); i++) {
				temp += strStart.charAt(i) - '0';
			}
			if (temp == target) {
				result = start;
				break;
			}
			start++;
		}
		System.out.println(result);
	}
}
