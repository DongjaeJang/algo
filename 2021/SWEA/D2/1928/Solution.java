package swea.d2.d2_1928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int A = 0;
		int a = 26;
		int zero = 52;
		int plus = 62;
		int slash = 63;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			char[] charSet = br.readLine().toCharArray();
			
			char[] resultSet = new char[charSet.length * 3 / 4];
			
			StringBuilder strMaker = new StringBuilder();
			for (char c : charSet) {
				int num = 0;
				if (c >= 'A' && c <= 'Z') num = c - 'A';
				else if (c >= 'a' && c <= 'z') num = c - 'a' + 26;
				else if (c >= '0' && c <= '9') num = c - '0' + 52;
				else if (c == '+') num = plus;
				else if (c == '/') num = slash;
				
				strMaker.append(decToBin(num));
			}
			String str = strMaker.toString();
			
			int index = 0;
			for (int i = 0; i < str.length(); i+=8) {
				resultSet[index++] = binToDec(str.substring(i, i + 8));
			}
			
			answer.append("#").append(tc).append(" ").append(new String(resultSet)).append("\n");
		}
		System.out.println(answer);
	}
	
	private static String decToBin (int num) {
		String result = "";
		while (true) {
			result = (num % 2) + result;
			num /= 2;
			if (num <= 1) {
				result = num + result;
				break;
			}
		}
		while (result.length() < 6) {
			result = "0" + result;
		}
		return result;
	}
	
	private static char binToDec (String num) {
		int result = 0;
		for (int i = 7; i >= 0; i--) {
			result += ((num.charAt(i) - '0') * (int)Math.pow(2, 7 - i));
		}
		return (char)result;
	}
}
