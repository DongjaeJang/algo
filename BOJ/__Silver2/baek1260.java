package day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), start = Integer.parseInt(st.nextToken());
		
		boolean[][] graph = new boolean[N + 1][N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from][to] = graph[to][from] = true;
		}
		
		StringBuilder str = new StringBuilder();
		dfs(graph, new boolean[N + 1], start, str);
		answer.append(str.toString().substring(0, str.toString().length() - 1)).append("\n");
		str = new StringBuilder();
		bfs(graph, new boolean[N + 1], start, str);
		answer.append(str.toString().substring(0, str.toString().length() - 1));
		
		System.out.println(answer);
	}
	
	private static void dfs(boolean[][] graph, boolean[] visited, int current, StringBuilder str) {
		str.append(current + " ");
		visited[current] = true;
		
		for (int next = 1; next < graph.length; next++) {
			if (!graph[current][next] || visited[next]) continue;
			dfs(graph, visited, next, str);
		}
	}
	
	private static void bfs(boolean[][] graph, boolean[] visited, int start, StringBuilder str) {
		Queue<Integer> queue = new LinkedList<>();
		visited[start] = true;
		queue.add(start);
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			str.append(current).append(" ");
			
			for (int next = 1; next < graph.length; next++) {
				if (!graph[current][next] || visited[next]) continue;
				visited[next] = true;
				queue.offer(next);
			}
		}
	}
}
