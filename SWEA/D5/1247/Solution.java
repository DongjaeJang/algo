package day13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import day13.Solution.Node;

public class Solution3 {
	public static class Node {
		int x;
		int y;
		
		public Node (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("/Users/dj/Desktop/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");

			Node[] nodes = new Node[n + 2];	// 회사, 고객, 집 
			nodes[0] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));	// 회사
			nodes[n + 1] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));	// 집
			for (int i = 1; i <= n; i++) nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));	// 고객 추가
			
			boolean[] isSelected = new boolean[n];
			min = Integer.MAX_VALUE;
			permutation(nodes, nodes[0], isSelected, n, 0, 0);
			
			answer.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(answer);
	}
	// 노드간 거리 체크
	public static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
	
	public static void permutation(Node[] nodes, Node current, boolean[] isSelected, int n, int count, int sum) {
		if (min < sum) return;
		if (count == n) {
			sum += getDistance(current.x, current.y, nodes[n + 1].x, nodes[n + 1].y);
			min = Math.min(min, sum);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (isSelected[i]) continue;
			
			isSelected[i] = true;
			permutation(nodes, nodes[i+1], isSelected, n, count + 1, sum + getDistance(current.x, current.y, nodes[i+1].x, nodes[i+1].y));
			isSelected[i] = false;
		}
	}
}
