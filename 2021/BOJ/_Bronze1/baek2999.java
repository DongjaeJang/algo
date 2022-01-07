package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Temp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		char[] charArray = br.readLine().toCharArray();
		int N = charArray.length;
		
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) if (N % i == 0) list.add(i);
		
		int R = 1;
		
		if (list.size() % 2 == 0) R = list.get(list.size() / 2 - 1);
		else R = list.get(list.size() / 2);
		
		for (int i = 0; i < R; i++) {
			for (int j = i; j < N; j+= R) {
				answer.append(charArray[j]);
			}
		}
		System.out.println(answer);
	}
}
