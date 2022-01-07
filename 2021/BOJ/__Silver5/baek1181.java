package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Temp {
	static class S implements Comparable<S>{
		String str;
		
		public S (String str) {
			this.str = str;
		}
		
		public int compareTo(S o) {
			if (this.str.length() == o.str.length()) return this.str.compareTo(o.str);
			return this.str.length() - o.str.length();
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) set.add(br.readLine());
		
		Iterator<String> iter = set.iterator();
		S[] strs = new S[set.size()];
		int index = 0;
		while (iter.hasNext()) strs[index++] = new S(iter.next());
		
		Arrays.sort(strs);
		
		for (int i = 0; i < strs.length; i++) answer.append(strs[i].str).append("\n");
		System.out.println(answer);
	}
}
