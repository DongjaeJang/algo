package swea.d4.d4_1233;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("/Users/dj/Desktop/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			boolean flag = true;
			for (int i = 0; i < n; i++) {
				if (!flag) {
					br.readLine();
					continue;
				}
				st = new StringTokenizer(br.readLine(), " ");
				int length = st.countTokens();
				st.nextToken();
				
				boolean opFlag = st.nextToken().matches("\\d+") ? false : true; 
				
				if (opFlag && length == 2 || !opFlag && length == 4) flag = false;
			}
			answer.append("#").append(tc).append(" ").append(flag ? 1 : 0).append("\n");
		}
		System.out.println(answer);
	}
}
