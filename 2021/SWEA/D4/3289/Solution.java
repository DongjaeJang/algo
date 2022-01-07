package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			answer.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
			
			int[] parents = new int[n + 1];	// 부모 노드 표시 배열
			for (int i = 0; i < n; i++) parents[i] = i;	// 자신으로 초기화
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if (op == 0) {
					if (findParent(parents, a) != findParent(parents, b)) unionParent(parents, a, b);
				} else {
					if (findParent(parents, a) == findParent(parents, b)) answer.append(1);
					else answer.append(0);
				}
			}
			answer.append("\n");
		}
		System.out.println(answer);
	}
	
	private static int findParent (int[] parents, int x) {
		if (parents[x] != x) return parents[x] = findParent(parents, parents[x]);
		return x;
	}
	
	private static void unionParent (int[] parents, int a, int b) {
		int ap = parents[a];
		int bp = parents[b];
		
		if (ap < bp) parents[bp] = ap;
		else parents[ap] = bp;
	}
}
