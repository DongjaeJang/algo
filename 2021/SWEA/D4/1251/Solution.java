package day17;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static class Node implements Comparable<Node>{
		int start;	// 출발
		int end;	// 도착
		long distance;	// 거리
		
		public Node (int start, int end, long distance) {
			this.start = start;
			this.end = end;
			this.distance = distance;
		}
		
		public int compareTo (Node o) {	// 거리 순 정렬
			if (this.distance - o.distance < 0) return - 1;
			else return 1;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("/Users/dj/Desktop/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());	// 노드 갯수
			
			int[] xlist = new int[n];	// x좌표
			int[] ylist = new int[n];	// y좌표

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) xlist[i] = Integer.parseInt(st.nextToken());	// x좌표 갱신
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) ylist[i] = Integer.parseInt(st.nextToken());	// y좌표 갱신

			double E = Double.parseDouble(br.readLine());	// 세율
			
			Node[] graph = new Node[n * (n - 1) / 2];	// 노드 간선 최대 갯수 : n(n-1)/2
			
			int index = 0;
			for (int i = 0; i < n - 1; i++) {	// 간선 정보 저장
				for (int j = i + 1; j < n; j++) {
					long distance = (long)(Math.pow(xlist[j] - xlist[i], 2) + Math.pow(ylist[j] - ylist[i], 2));
					graph[index++] = new Node(i, j, distance);
				}
			}
			
			Arrays.sort(graph);	// 최소 간선부터 들어가야하므로 오름차순 정렬
			
			int[] parents = new int[n];	// 부모 표기 배열
			for (int i = 0; i < n; i++) parents[i] = i;
			
			double result = 0.0;
			int count = 0;
			for (Node node : graph) {
				int start = node.start;
				int end = node.end;
				double distance = node.distance;
				
				if (findParent(parents, start) == findParent(parents, end)) continue;	// 사이클 형성되면 continue;
				unionParent(parents, start, end);	// 연결
				result += distance;
	
				if (++count == n - 1) break;
			}
			
			answer.append("#").append(tc).append(" ").append(Math.round(result * E)).append("\n");
		}
		System.out.println(answer);
	}
	// 부모 노드 찾기
	private static int findParent(int[] parents, int x) {
		if (parents[x] != x) return parents[x] = findParent(parents, parents[x]);
		return x;
	}
	// 노드간 연결
	private static void unionParent(int[] parents, int a, int b) {
		int ap = parents[a];
		int bp = parents[b];
		
		if (ap < bp) parents[bp] = ap;
		else parents[ap] = bp;
	}
}
