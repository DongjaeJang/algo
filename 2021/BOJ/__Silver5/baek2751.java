package boj_self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ2751 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> numbers = new PriorityQueue();
		
		for (int i = 0; i < N; i++) {
			int target = Integer.parseInt(br.readLine());
			numbers.add(target);
		}
		for (int i = 0; i < N; i++) answer.append(numbers.poll()).append("\n");
		System.out.println(answer);
	}
}
