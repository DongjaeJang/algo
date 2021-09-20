package boj_self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10828 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack();
		for (int tc = 0; tc < N; tc++) {
			String[] s = br.readLine().split(" ");
			
			if (s[0].equals("push")) {
				stack.push(Integer.parseInt(s[1]));
			} else if (s[0].equals("pop")) {
				answer.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
			} else if (s[0].equals("size")) {
				answer.append(stack.size()).append("\n");
			} else if (s[0].equals("empty")) {
				answer.append(stack.isEmpty() ? 1 : 0).append("\n");
			} else if (s[0].equals("top")) {
				answer.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
			}
		}
		System.out.println(answer);
	}
}
