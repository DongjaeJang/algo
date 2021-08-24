package hwalgo16_서울_07반_장동재;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
			
			int[] parents = new int[N + 1];
			for (int i = 0; i <= N; i++) parents[i] = i;
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if (findParent(parents, a) == findParent(parents, b)) continue;
				else unionParent(parents, a, b);
			}
			
			Set<Integer> set = new HashSet<>();
			
			for (int i = 1; i <= N; i++) findParent(parents, i);
			for (int i = 1; i <= N; i++) set.add(parents[i]);
			
			answer.append("#").append(tc).append(" ").append(set.size()).append("\n");
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
