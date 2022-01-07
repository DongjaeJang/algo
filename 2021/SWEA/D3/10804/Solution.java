package swea.d3.d3_10804;

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
		
		Map<Character, Character> cMap = new HashMap<Character, Character>() {{
			put('p', 'q');
			put('q', 'p');
			put('b', 'd');
			put('d', 'b');
		}};
		for (int tc = 1; tc <= T; tc++) {
			char[] charArray = br.readLine().toCharArray();
			int cLen = charArray.length;

			answer.append("#").append(tc).append(" ");
			for (int i = 0; i < cLen; i++) answer.append(cMap.get(charArray[cLen - i - 1]));
			answer.append("\n");
		}
		System.out.println(answer);
	}
}
