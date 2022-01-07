package day29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, result;
	static int[] nodes;
	static List<Integer>[] nodeList;
	static int[] populations;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		nodes = new int[N + 1];
		for (int i = 1; i <= N; i++) nodes[i] = i;
		
		st = new StringTokenizer(br.readLine());
		populations = new int[N + 1];
		for (int i = 1; i <= N; i++) populations[i] = Integer.parseInt(st.nextToken());
		
		nodeList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			nodeList[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			
			int tempN = Integer.parseInt(st.nextToken());
			for (int j = 0; j < tempN; j++) nodeList[i].add(Integer.parseInt(st.nextToken()));	// 연결 관계 체크
		}
		
		result = Integer.MAX_VALUE;
		combinations(new boolean[N + 1], 0, 1, 0, 0);
		
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
	
	public static void combinations(boolean[] visited, int count, int index, int first, int second) {
		if (count == N) {
			if (first == 0 || second == 0) return;	// 한 구역이라도 포함되어야하므로 리턴
			
			int[] firstAreas = new int[first];	// 지역구 1
			int[] secondAreas = new int[second];	// 지역구 2
			
			int firstIdx = 0, secondIdx = 0;
			for (int i = 1; i <= N; i++) {
				if (visited[i]) firstAreas[firstIdx++] = i; 
				else secondAreas[secondIdx++] = i;	// 지역구끼리 나눔
			}
			
			// 지역구가 서로 연결되어있는지 체크
			if (!isOkay(firstAreas) || !isOkay(secondAreas)) return;
			
			int firstSum = 0, secondSum = 0;
			for (int i = 0; i < first; i++) firstSum += populations[firstAreas[i]];
			for (int i = 0; i < second; i++) secondSum += populations[secondAreas[i]];

			int tempResult = Math.abs(firstSum - secondSum);
			
			result = Math.min(result, tempResult);	// 최댓값 업데이트
			return ;
		}
		
		visited[index] = true;
		combinations(visited, count + 1, index + 1, first + 1, second);
		visited[index] = false;
		combinations(visited, count + 1, index + 1, first, second + 1);
	}
	
	public static boolean isOkay(int[] areas) {
		boolean[] visited = new boolean[N + 1];
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(areas[0]);
		visited[areas[0]] = true;
		int cnt = 1;
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			
			for (int i = 0; i < areas.length; i++) {
				if (visited[areas[i]]) continue;
				
				for (int j = 0; j < nodeList[current].size(); j++) {
					int next = nodeList[current].get(j);
					
					if (next == areas[i]) {
						visited[areas[i]] = true;
						cnt++;
						queue.offer(areas[i]);
						break;
					}
				}
			}
		}
		
		return cnt == areas.length ? true : false;
	}
}
