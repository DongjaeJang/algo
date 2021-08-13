package hwalgo08_서울_07반_장동재;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] numbers;
	static int[] list;
	static boolean flag;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		numbers = new int[9];
		list = new int[7];
		for (int i = 0; i < 9; i++) numbers[i] = Integer.parseInt(br.readLine());
		combination(0, 0);
	}
	
	private static void combination(int count, int index) {
		if (flag) return;
		if (count == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += list[i];
			}
			if (sum == 100) {
				flag = true;
				for (int i = 0; i < 7; i++) {
					System.out.println(list[i]);
				}
			}
			return;
		}
		
		for (int i = index; i < 9; i++) {
			list[count] = numbers[i];
			combination(count+1, i + 1);
			combination(count, i + 1);
		}
	}
}
