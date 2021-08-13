package day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 도시 정보 생성
		int[][] city = new int[N][N];	// 도시 정보
		List<int[]> houseLocations = new ArrayList<>();	// 집 위치
		List<int[]> chickenLocations = new ArrayList<>();	// 치킨집 위치
		
		// 맵 init
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if (city[i][j] == 1) houseLocations.add(new int[] {i, j});
				else if (city[i][j] == 2) chickenLocations.add(new int[] {i, j}); 
			}
		}
		
		// powerSet 생성
		int min = Integer.MAX_VALUE;
		
		for (int i = 1; i < 1 << chickenLocations.size(); i++) {
			int count = 0;
			int[] houseDistance = new int[houseLocations.size()];
			Arrays.fill(houseDistance, Integer.MAX_VALUE);
			for (int j = 0; j < chickenLocations.size(); j++) {
				if (count == M) break;
				if ((i & (1 << j)) != 0) {
					count++;
					int[] currentChicken = chickenLocations.get(j);
					for (int k = 0; k < houseLocations.size(); k++) {
						int[] currentHouse = houseLocations.get(k);
						int distance = Math.abs(currentChicken[0] - currentHouse[0]) + Math.abs(currentChicken[1] - currentHouse[1]);
						houseDistance[k] = Math.min(distance, houseDistance[k]);
					}
				}
			}
			int sum = 0;
			for (int j = 0; j < houseDistance.length; j++) sum += houseDistance[j];
			min = Math.min(min, sum);
		}

		System.out.println(min);
		
	}
}
