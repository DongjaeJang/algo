package swea.d1.d1_2058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] numList = br.readLine().split("");
		int sum = 0;
		for (String num : numList) sum += Integer.parseInt(num);
		
		System.out.println(sum);
	}
}
