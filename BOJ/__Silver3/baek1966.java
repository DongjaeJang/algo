package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Temp {
	static class Printer {
		int index;
		int importance;
		
		public Printer (int index, int importance) {
			this.index = index;
			this.importance = importance;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()), target = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			Queue<Printer> queue = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
			
			for (int i = 0; i < N; i++) {
				int importance = Integer.parseInt(st.nextToken());
				queue.offer(new Printer(i, importance));
				pq.add(importance);
			}
			
			int count = 1;
			while (!queue.isEmpty()) {
				Printer current = queue.poll();
				if (current.importance == pq.peek()) {
					if (current.index == target) {
						answer.append(count).append("\n");
						break;
					} else {
						count++;
						pq.poll();
					}
				} else {
					queue.offer(current);
				}
			}
		}
		System.out.println(answer);
	}
}
