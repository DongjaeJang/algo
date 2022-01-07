package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Temp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Set<Integer> numbers = new HashSet<>();
		for (int i = 0; i < 10; i++) numbers.add(Integer.parseInt(br.readLine()) % 42);
		
		System.out.println(numbers.size());
	}
}
