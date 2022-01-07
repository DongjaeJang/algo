package boj_self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()) - 1;
		
		List<Integer> array = new ArrayList<>();
		for (int i = 1; i <= N; i++) array.add(i);
		
		int index = 0;
		while (N > 0) {
			index += (K % N);
			if (index >= N) index %= N;
			if (answer.length() == 0) answer.append("<");
			else answer.append(", ");
			answer.append(array.remove(index));
			if (array.size() == 0) answer.append(">");
			--N;
		}
		System.out.println(answer);
	}
}
