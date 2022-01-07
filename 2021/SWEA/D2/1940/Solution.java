package swea.d2.d2_1940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int speed = 0;
			int distance = 0;
			
			for (int i = 0; i < N; i++) {
				String[] info = br.readLine().split(" ");
				if (info[0].equals("1")) {
					speed += Integer.parseInt(info[1]);
				} else if (info[0].equals("2")) {
					speed -= Integer.parseInt(info[1]);
					if (speed < 0) speed = 0;
				}
				distance += speed;
			}
			
			answer.append("#").append(tc).append(" ").append(distance).append("\n");
		}
		System.out.println(answer);
	}
}
