package swea.d3.d3_11688;

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
			int top = 1, bottom = 1;
			char[] opList = br.readLine().toCharArray();
			
			for (char op : opList) {
				if (op == 'L') 
					bottom += top;
				else 
					top += bottom;
			}
			
			answer.append("#").append(tc).append(" ").append(top).append(" ").append(bottom).append("\n");
		}
		System.out.println(answer);
	}
}
