package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Temp {
	static class Computer {
		int idx;
		List<Computer> adj;
		
		public Computer(int idx) {
			this.idx = idx;
			adj = new ArrayList<Computer>();
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		Computer[] computer = new Computer[N + 1];
		for (int i = 1; i <= N; i++) computer[i] = new Computer(i);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			computer[b].adj.add(computer[a]);
		}
		
		int[] freq = new int[N + 1];
		int max = -1;
		for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            visited[i] = true;
			dfs(freq, visited, computer[i], computer[i]);
			if (max < freq[i]) max = freq[i];
		}
		
		for (int i = 1; i <= N; i++) if (freq[i] == max) answer.append(i).append(" ");
		System.out.println(answer);
	}
	
	private static void dfs(int[] freq, boolean[] visited, Computer n, Computer temp) {
		freq[n.idx]++;
		for (int i = 0; i < temp.adj.size(); i++) {
			if (visited[temp.adj.get(i).idx]) continue;
			visited[temp.adj.get(i).idx] = true;
			dfs(freq, visited, n, temp.adj.get(i));
		}
	}
}
