package boj_self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class BOJ10845 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> queue = new LinkedList<>();
		for (int tc = 0; tc < N; tc++) {
			String[] s = br.readLine().split(" ");
			
			if (s[0].equals("push")) {
				queue.add(Integer.parseInt(s[1]));
			} else if (s[0].equals("pop")) {
				answer.append(queue.isEmpty() ? -1 : queue.remove(0)).append("\n");
			} else if (s[0].equals("size")) {
				answer.append(queue.size()).append("\n");
			} else if (s[0].equals("empty")) {
				answer.append(queue.isEmpty() ? 1 : 0).append("\n");
			} else if (s[0].equals("front")) {
				answer.append(queue.isEmpty() ? -1 : queue.get(0)).append("\n");
			} else if (s[0].equals("back")) {
				answer.append(queue.isEmpty() ? -1 : queue.get(queue.size() - 1)).append("\n");
			}
		}
		System.out.println(answer);
	}
}
