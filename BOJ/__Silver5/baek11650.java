package boj_self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11650 {
	public static class Point implements Comparable<Point>{
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (this.x == o.x) return this.y - o.y;
			return this.x - o.x;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Point[] points = new Point[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(points);
		
		for (int i = 0; i < N; i++) 
			answer.append(points[i].x).append(" ").append(points[i].y).append("\n");
		
		System.out.println(answer);
	}
}
