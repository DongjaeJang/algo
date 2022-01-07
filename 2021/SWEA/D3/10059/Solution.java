package swea.d3.d3_10059;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			String front = str.substring(0, 2);
			String behind = str.substring(2);
			
			boolean MMYYFlag = false;
			boolean YYMMFlag = false;
			
			if (Integer.parseInt(front) <= 12 && Integer.parseInt(front) >= 1) MMYYFlag = true;
			if (Integer.parseInt(behind) <= 12 && Integer.parseInt(behind) >= 1) YYMMFlag = true;
			
			answer.append("#").append(tc).append(" ");
			if (MMYYFlag && YYMMFlag) answer.append("AMBIGUOUS").append("\n");	// 둘다 해당 o
			else if (MMYYFlag) answer.append("MMYY").append("\n");
			else if (YYMMFlag) answer.append("YYMM").append("\n");
			else answer.append("NA").append("\n");
		}
		System.out.println(answer);
	}
}
