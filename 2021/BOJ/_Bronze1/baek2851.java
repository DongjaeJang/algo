package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Temp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int prev = 0, current = 0;
		for (int i = 0; i < 10; i++) {
			prev = current;
			current += Integer.parseInt(br.readLine());
			
			if (current >= 100) break;
		}
		
		System.out.println(Math.abs(100 - prev) < Math.abs(100 - current) ? prev : current);
	}
}
