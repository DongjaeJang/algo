package swea.d2.d2_1976;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int hour_1 = Integer.parseInt(st.nextToken());
			int minute_1 = Integer.parseInt(st.nextToken());
			int hour_2 = Integer.parseInt(st.nextToken());
			int minute_2 = Integer.parseInt(st.nextToken());
			
			int hour = hour_1 + hour_2;
			int minute = minute_1 + minute_2;
			
			if (minute >= 60) {
				minute -= 60;
				hour += 1;
			}
			if (hour >= 13) {
				hour -= 12;
			}
			answer.append("#").append(i).append(" ").append(hour).append(" ").append(minute).append("\n");
		}
		System.out.println(answer.toString());
	}
}