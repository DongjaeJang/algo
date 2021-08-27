package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Temp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int target = N;
		
		int count = 0;
		do {
			target = Integer.parseInt(getLeft(target) + "" + getRight(target));
			count++;
		} while (target != N);
		
		System.out.println(count);
	}
	
	private static int getLeft(int num) {
		if (num < 10) return num;
		else return String.valueOf(num).charAt(1) - '0';
	}
	
	private static int getRight(int num) {
		if (num < 10) return num;
		else return (String.valueOf(num).charAt(0) - '0' + String.valueOf(num).charAt(1) - '0') % 10;
	}
}
