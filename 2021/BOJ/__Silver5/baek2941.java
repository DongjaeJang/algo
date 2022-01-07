package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Temp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<String> list = new ArrayList<>();
		list.add("c="); list.add("c-"); list.add("dz="); list.add("d-");
		list.add("lj"); list.add("nj"); list.add("s="); list.add("z="); 
		
		char[] charArray = br.readLine().toCharArray();
		int len = charArray.length;

		int answer = 0;
		for (int i = 0; i < len; i++) {
			String temp = "";
			if (i + 1 < len) {
				for (int j = 0; j < 2; j++) temp += charArray[i + j];
				if (list.contains(temp)) {
					i++;
					answer++;
					continue;
				}
			}
			if (i + 2 < len) {
				temp += charArray[i + 2];
				if (list.contains(temp)) {
					i += 2;
					answer++;
					continue;
				}
			}
			answer++;
		}
		
		System.out.println(answer);
	}
}
