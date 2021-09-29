package hwalgo26_서울_07반_장동재;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());
			
			List<Integer>[] high = new ArrayList[N];
			List<Integer>[] low = new ArrayList[N];
			
			for (int i = 0; i < N; i++) { high[i] = new ArrayList<Integer>(); low[i] = new ArrayList<Integer>(); }
			
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int small = Integer.parseInt(st.nextToken()) - 1, tall = Integer.parseInt(st.nextToken()) - 1;
				high[small].add(tall);
				low[tall].add(small);
			}
			
			int[] count = new int[N];
			for (int i = 0; i < N; i++) {
				dfs(high, count, new boolean[N], i);
				dfs(low, count, new boolean[N], i);
			}
			
			int result = 0;
			for (int i = 0; i < N; i++) if (count[i] == N - 1) result++;
			
			answer.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(answer);
	}
	
	public static void dfs(List<Integer>[] graph, int[] count, boolean[] visited, int current) {
		visited[current] = true;
		
		for (int i = 0; i < graph[current].size(); i++) {
			int next = graph[current].get(i);
			if (visited[next]) continue;
			count[next]++;
			dfs(graph, count, visited, next);
		}
	}
}
