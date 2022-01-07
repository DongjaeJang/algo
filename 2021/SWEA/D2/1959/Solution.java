package swea.d2.d2_1959;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] listN = new int[N];
			int[] listM = new int[M];

			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				listN[j] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				listM[j] = Integer.parseInt(st.nextToken());
			}
			
			if (N < M) {
				int[] temp = Arrays.copyOf(listN, listN.length);
				listN = Arrays.copyOf(listM, listM.length);
				listM = Arrays.copyOf(temp, temp.length);
				
				int temp2 = N;
				N = M;
				M = temp2;
			}
			
			int sum = 0;
			for (int j = 0; j < N - M + 1; j++) {
				int tempSum = 0;
				for (int r = 0; r < M; r++) {
					tempSum += (listN[j+r] * listM[r]);
				}
				if (sum < tempSum) sum = tempSum;
			}
			
			answer.append("#").append(i).append(" ").append(sum).append("\n");
		}
		System.out.println(answer);
	}
}
