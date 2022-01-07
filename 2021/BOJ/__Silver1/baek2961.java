package day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<int[]> list;
	static long min = Integer.MAX_VALUE;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;

		// 재료 개수
		N = Integer.parseInt(br.readLine());

		// 재료 리스트 생성
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			list.add(new int[] { s, b });
		}
		isSelected = new boolean[N];
		getPowerSet(0);
		System.out.println(min);
	}
	
	private static void getPowerSet(int count) {
		if (count == N) {
			long tempS = 1, tempB = 0;
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					flag = true;
					int[] info = list.get(i);
					tempS *= info[0];
					tempB += info[1];
				}
			}
			if (flag) {
				if (min > Math.abs(tempS - tempB)) min = Math.abs(tempS - tempB);
			}
			return ;
		}
		
		isSelected[count] = true;
		getPowerSet(count+1);
		isSelected[count] = false;
		getPowerSet(count+1);
	}
}
