package swea.d3.d3_11445;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String a = br.readLine().trim();
			String b = br.readLine().trim();
			
			boolean flag = false;
			int index = 0;
			while (index != a.length()) {
				char aChar = a.charAt(index);
				char bChar = b.charAt(index);
				index++;
				
				if (aChar < bChar) {
					flag = true;
					break;
				} 
			}
			if (!flag && (b.charAt(index) != 'a' || b.length() > a.length()+ 1)) {
				flag = true;
			}
			answer.append("#").append(tc).append(" ").append(flag ? 'Y' : 'N').append("\n");
		}
		System.out.println(answer);
	}
}
