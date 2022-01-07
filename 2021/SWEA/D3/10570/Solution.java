package swea.d3.d3_10570;

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
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int result = 0;
			for (int i = A; i <= B; i++) {
				if (checkPalindrome(i) && checkSqrt(i) && checkPalindrome((int)Math.sqrt(i))) result++; 
			}
			
			answer.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(answer);
	}
	
	private static boolean checkPalindrome(int num) {
		String strNum = num + "";
		int j = strNum.length() - 1;
		int i = 0;
		while (i < j) if (strNum.charAt(i++) != strNum.charAt(j--)) return false;
		return true;
	}
	
	private static boolean checkSqrt(int num) {
		int intSqrt = (int)Math.sqrt(num);
		double doubleSqrt = Math.sqrt(num);
		
		if (intSqrt != doubleSqrt) return false;
		else return true;
	}
}
