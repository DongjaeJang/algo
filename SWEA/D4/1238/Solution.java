package day15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("/Users/dj/Desktop/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()), start = Integer.parseInt(st.nextToken());	// 개수, 시작 노드
			
			Map<Integer, List<Integer>> graph = new HashMap<>();
			for (int i = 1; i < 101; i++) graph.put(i, new ArrayList<>());
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				List<Integer> list = graph.get(from);
				if (list.contains(to)) continue;
				list.add(to);
				graph.put(from, list);
			}
			System.out.println(graph);
			boolean[] visited = new boolean[101];
			int[] distance = new int[101];
			
//			visited[start] = true;
//			dfs(graph, distance, visited, start, 0);
			bfs(graph, distance, visited, start);
			
			int maxDistance = -1, index = -1;
			for (int i = 1; i < 101; i++) {
				if (distance[i] >= maxDistance) {
					maxDistance = distance[i];
					index = i;
				}
			}
			
			answer.append("#").append(tc).append(" ").append(index).append("\n");
		}
		System.out.println(answer);
	}
	
//	public static void dfs(Map<Integer, List<Integer>> graph, int[] distance, boolean[] visited, int current, int count) {
//		List<Integer> currentGraph = graph.get(current);
//		System.out.println(currentGraph);
//		
//		for (int i = 0; i < currentGraph.size(); i++) {
//			int next = currentGraph.get(i);
//			if (visited[next]) continue;
//			visited[next] = true;
//			distance[next] = Math.max(distance[next], count + 1);
//			dfs(graph, distance, visited, next, count + 1);
//		}
//	}
	
	public static void bfs(Map<Integer, List<Integer>> graph, int[] distance, boolean[] visited, int start) {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {start, 0});
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			
			List<Integer> nextNodes = graph.get(current[0]);
			for (int i = 0; i < nextNodes.size(); i++) {
				int next = nextNodes.get(i);
				if (visited[next]) continue;
				visited[next] = true;
				
				distance[next] = current[1] + 1;
				queue.add(new int[] {next, distance[next]});
			}
		}
	}
}
