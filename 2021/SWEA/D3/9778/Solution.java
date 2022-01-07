package swea.d3.d3_9778;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] totalCards = new int[12];
			for (int i = 2; i < 12; i++) {
				if (i != 10) totalCards[i] = 4;
				else totalCards[i] = 16;
			}
			int[] myCards = new int[N];
			
			int mySum = 0;
			for (int i = 0; i < N; i++) {
				myCards[i] = Integer.parseInt(br.readLine());
				mySum += myCards[i];
				totalCards[myCards[i]]--;
			}
			
			int cardTotal = 52 - N;
			int remain = 21 - mySum;
			
			answer.append("#").append(tc).append(" ");
			if (remain > 11) answer.append("GAZUA");
			else {
				int isOk = 0;
				for (int i = 2; i < 12; i++) {
					if (i <= remain) isOk += totalCards[i];
				}
				answer.append(isOk >= cardTotal - isOk ? "GAZUA" : "STOP");
			}
			answer.append("\n");
		}
		System.out.println(answer);
	}
}
