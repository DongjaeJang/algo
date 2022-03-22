package practice;

import java.io.*;
import java.util.*;

public class BOJ7568 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] info = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			int count = 1;
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				if (info[i][0] < info[j][0] && info[i][1] < info[j][1]) count++;
			}
			answer.append(count).append(" ");
		}
		
		System.out.println(answer);
	}
}
