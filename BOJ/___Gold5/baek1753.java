package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int index;
		int weight;
		
		public Node (int index, int weight) {
			this.index = index;
			this.weight = weight;
		}

		public int compareTo(Node o) {
			if (this.weight < o.weight) return -1;
			else return 1;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());	// 노드 갯수, 간선 갯수
		int start = Integer.parseInt(br.readLine());
		
		
		Map<Integer, List<Node>> graph = new HashMap<>();	// 그래프 생성
		for (int i = 1; i <= N; i++) graph.put(i, new ArrayList<Node>());	// 그래프 초기화
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			List<Node> list = graph.get(from);
			list.add(new Node(index, weight));	// 간선 추가
			graph.put(from, list);	// 그래프 업데이트
		}

		int[] distance = new int[N + 1];	// 거리 배열
		boolean[] visited = new boolean[N + 1];	// 체크 배열
		
		for (int i = 0; i <= N; i++) distance[i] = Integer.MAX_VALUE;	// 맥스값 초기화
		distance[start] = 0;	// 스타트는 0으로
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>();	// 뽑을 때 거리가 짧은 순으로 뽑아야되므로
		queue.offer(new Node(start, distance[start]));	// 스타트 노드 큐에 추가
		
		while (!queue.isEmpty()) {	// 끝까지 순회
			Node current = queue.poll();	// 가장 짧은 작은 노드
			
			if (visited[current.index]) continue;	// 체크한노드는 볼 필요 없음
			visited[current.index] = true;	// 체크
			List<Node> list = graph.get(current.index);	// 연결된 노드 정보 리스트
			
			for (int i = 0; i < list.size(); i++) {
				Node next = list.get(i);	// 다음 노드
				if (visited[next.index]) continue;	// 체크한노드는 볼 필요 없음
				distance[next.index] = Math.min(distance[next.index], current.weight + next.weight);	// 최소 거리 업데이트
				queue.add(new Node(next.index, distance[next.index]));	// 큐에 추가
			}
		}
		
		for (int i = 1; i <= N; i++) answer.append(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]).append("\n");
		
		System.out.println(answer);
	}
}
