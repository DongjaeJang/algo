package swea.d2.d2_1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			br.readLine();
			st = new StringTokenizer(br.readLine(), " ");

			List<Integer> numList = new ArrayList<Integer>();
			while (st.hasMoreTokens())
				numList.add(Integer.parseInt(st.nextToken()));
			numList.sort(null);
			answer.append("#").append(i);
			for (int j = 0; j < numList.size(); j++) {
				answer.append(" ").append(numList.get(j));
			}
			answer.append("\n");
		}
		System.out.println(answer);
	}
}
