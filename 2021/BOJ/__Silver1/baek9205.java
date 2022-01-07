package hwalgo20_서울_07반_장동재;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] nodes = new int[N + 2][2];
			for (int i = 0; i < N + 2; i++) {
				st = new StringTokenizer(br.readLine());
				nodes[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) }; 
			}
			
			boolean[][] checked = new boolean[N + 2][N + 2];
			
			for (int i = 0; i < N + 2; i++) {
				for (int j = i; j < N + 2; j++) {
					int dist = Math.abs(nodes[i][0] - nodes[j][0]) + Math.abs(nodes[i][1] - nodes[j][1]);
					if (dist <= 1000) {
						checked[i][j] = true;
						checked[j][i] = true;
					}
				}
			}
			
			for (int k = 0; k < N + 2; k++) {
				for (int i = 0; i < N + 2; i++) {
					for (int j = 0; j < N + 2; j++) {
						if (checked[i][k] && checked[k][j]) checked[i][j] = true;
					}
				}
			}
			
			answer.append(checked[0][N + 1] ? "happy" : "sad").append("\n");
		}
		System.out.println(answer);
	}
}
