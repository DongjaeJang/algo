package practice;

import java.io.*;
import java.util.*;

public class BOJ14889 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] playerBoard = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				playerBoard[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int half = N / 2;
		int[] array = new int[N];
		for (int i = N - half; i < N; i++) array[i] = 1;
		
		int result = Integer.MAX_VALUE;
		do {
			int[] teamA = new int[half], teamB = new int[half];
			int aIndex = 0, bIndex = 0;
			
			for (int i = 0; i < N; i++) {
				if (array[i] == 0) teamA[aIndex++] = i;
				else teamB[bIndex++] = i;
			}
			
			int sumA = 0, sumB = 0;
			for (int i = 0; i < half - 1; i++) {
				for (int j = i + 1; j < half; j++) {
					sumA += (playerBoard[teamA[i]][teamA[j]] + playerBoard[teamA[j]][teamA[i]]);
					sumB += (playerBoard[teamB[i]][teamB[j]] + playerBoard[teamB[j]][teamB[i]]);
				}
			}
			
			result = Math.min(result, Math.abs(sumA - sumB));
		} while (nextPermutation(array));
		
		System.out.println(result);
	}

	private static boolean nextPermutation(int[] array) {
		int N = array.length;
		
		int i = N - 1;
		
		while (i > 0 && array[i - 1] >= array[i]) --i;
		if (i == 0) return false;
		
		int j = N - 1;
		while (array[i - 1] >= array[j]) --j;
		swap(array, i - 1, j);
		
		int k = N - 1;
		while (i < k) swap(array, i++, k--);
		return true;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
