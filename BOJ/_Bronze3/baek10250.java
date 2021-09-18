package boj_self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10250 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
			answer.append(((N % H == 0) ? H : N % H) * 100 + ((N % H != 0) ? (N / H + 1) : (N / H))).append("\n");
		}
		System.out.println(answer);
	}
}
