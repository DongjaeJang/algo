package swea.d3.d3_11856;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			char[] charArray = br.readLine().toCharArray();
			Map<Character, Integer> freqMap = new HashMap<>();
			
			for (char c : charArray) {
				if (freqMap.containsKey(c)) freqMap.put(c, freqMap.get(c)+1);
				else freqMap.put(c, 1);
			}

			boolean flag = true;
			if (freqMap.size() != 2) flag = false;
			if (freqMap.values().contains(1)) flag = false;
			
			answer.append("#").append(tc).append(" ").append(flag ? "Yes" : "No").append("\n");
		}
		System.out.println(answer);
	}
}