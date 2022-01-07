package boj_self;

import java.io.*;
import java.util.*;

class Programmers_더_맵게 {
	public int solution(int[] scoville, int K) {
		int answer = 0;

		PriorityQueue<Integer> list = new PriorityQueue<>();
		for (int s : scoville)
			list.offer(s);

		while (true) {
			if (list.peek() >= K)
				break;
			if (list.size() == 1)
				return -1;
			int a = list.poll();
			int b = list.poll();
			list.offer(a + b * 2);
			answer++;
		}

		return answer;
	}
}
