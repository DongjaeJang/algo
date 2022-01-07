package boj_self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ10816 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		Map<Integer, Integer> cards = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int target = Integer.parseInt(st.nextToken());
			if (cards.containsKey(target)) cards.put(target, cards.get(target) + 1);
			else cards.put(target, 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			if (cards.containsKey(target)) answer.append(cards.get(target)).append(" ");
			else answer.append(0).append(" ");
		}
		System.out.println(answer.substring(0, answer.length() - 1));
	}
}
