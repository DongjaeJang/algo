package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Temp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int[] numbers = new int[N];
			int sum = 0;
			
			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
				sum += numbers[i];
			}
			
			double avg = sum / (double)N;
			
			int count = 0;
			for (int i = 0; i < N; i++) if (numbers[i] > avg) count++;
			
			String tempAnswer = Math.round(count / (double)N * 100000) / 1000. + "";
			String[] splitedAnswer = new String[2];
			
			st = new StringTokenizer(tempAnswer, ".");
			for (int i = 0; i < 2; i++) splitedAnswer[i] = st.nextToken();
			
			if (splitedAnswer[1].length() < 3) {
				while (splitedAnswer[1].length() < 3) splitedAnswer[1] += "0";
			}
			
			answer.append(String.join(".", splitedAnswer)).append("%").append("\n");
		}
		
		System.out.println(answer);
	}
}
