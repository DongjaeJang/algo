package day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		char[] charArray = br.readLine().toCharArray();

		boolean parenStart = false;
		StringBuilder sb = new StringBuilder();
		
		for (char c : charArray) {
			if (c == '<') {
				answer.append(sb.reverse());
				sb = new StringBuilder();
				
				parenStart = true;
				answer.append(c);
			} else if (c == '>') {
				answer.append(sb);
				sb = new StringBuilder();
				
				parenStart = false;
				answer.append(c);
			} else if (c == ' ') {
				answer.append(parenStart ? sb : sb.reverse());
				sb = new StringBuilder();
				
				answer.append(c);
			} else {
				sb.append(c);
			}
		}
		answer.append(sb.reverse());
		
		System.out.println(answer);
	}
}
