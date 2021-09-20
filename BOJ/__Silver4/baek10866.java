package boj_self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ10866 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> deque = new ArrayList<>();
		for (int tc = 0; tc < N; tc++) {
			String[] s = br.readLine().split(" ");
			
			if (s[0].equals("push_front")) {
				deque.add(0, Integer.parseInt(s[1]));
			} else if (s[0].equals("push_back")) {
				deque.add(Integer.parseInt(s[1]));
			} else if (s[0].equals("pop_front")) {
				answer.append(deque.isEmpty() ? -1 : deque.remove(0)).append("\n");
			} else if (s[0].equals("pop_back")) {
				answer.append(deque.isEmpty() ? -1 : deque.remove(deque.size() - 1)).append("\n");
			} else if (s[0].equals("size")) {
				answer.append(deque.size()).append("\n");
			} else if (s[0].equals("empty")) {
				answer.append(deque.isEmpty() ? 1 : 0).append("\n");
			} else if (s[0].equals("front")) {
				answer.append(deque.isEmpty() ? -1 : deque.get(0)).append("\n");
			} else if (s[0].equals("back")) {
				answer.append(deque.isEmpty() ? -1 : deque.get(deque.size() - 1)).append("\n");
			}
		}
		System.out.println(answer);
	}
}
