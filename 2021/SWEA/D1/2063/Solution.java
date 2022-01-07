package swea.d1.d1_2063;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] strNumList = br.readLine().split(" ");
		int[] numList = new int[N];
		for (int i = 0; i < N; i++) {
			numList[i] = Integer.parseInt(strNumList[i]);
		}
		Arrays.sort(numList);
		System.out.println(Arrays.toString(numList));
		System.out.println(numList[N / 2]);
	}
}
