package boj_self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			Stack<Character> stack = new Stack<>();
			char[] charArray = br.readLine().toCharArray();
			
			boolean flag = true;
			for (char c : charArray) {
				if (c == '(') stack.push(c);
				else {
					if (stack.isEmpty()) {
						flag = false;
						break;
					}
					stack.pop();
				}
			}
			answer.append((flag && stack.size() == 0) ? "YES" : "NO").append("\n");
		}
		System.out.println(answer);
	}
}
