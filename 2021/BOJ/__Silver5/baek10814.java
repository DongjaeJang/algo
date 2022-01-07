package boj_self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ10814 {
	public static class Person implements Comparable<Person> {
		int index;
		int age;
		String name;
		
		public Person(int index, int age, String name) {
			this.index = index;
			this.age = age;
			this.name = name;
		}
		
		public int compareTo(Person o) {
			if (this.age == o.age) return this.index - o.index;
			return this.age - o.age;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Person> people = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			people.add(new Person(i, Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		
		for (int i = 0; i < N; i++) {
			Person cur = people.poll();
			answer.append(cur.age).append(" ").append(cur.name).append("\n");
		}
		System.out.println(answer);
	}
}
