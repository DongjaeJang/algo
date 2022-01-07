package boj_self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1874 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		
		int num = 1;
		
		for (int i = 0; i < N; i++) {
			int current = Integer.parseInt(br.readLine());
			
			while (num <= current) {
				stack.push(num++);
				answer.append("+\n");
			}
			
			if (stack.peek() == current) {
				stack.pop();
				answer.append("-\n");
			} else {
				break;
			}
		}
		
		System.out.println(stack.size() == 0 ? answer : "NO");
	}
}
