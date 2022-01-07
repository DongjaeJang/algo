package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Temp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		while (true) {
			String str = br.readLine();
			if (str.equals("0")) break;
			
			int i = 0;
			int j = str.length() - 1;
			boolean flag = true;
			
			while (i < j) {
				if (str.charAt(i++) != str.charAt(j--)) {
					flag = false;
					break;
				}
			}
			
			if (flag) answer.append("yes");
			else answer.append("no");
			answer.append("\n");
		}
		
		System.out.println(answer);
	}
}
