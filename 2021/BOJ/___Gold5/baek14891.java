package boj_self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14891 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] wheels = new int[4][8];
		for (int i = 0; i < 4; i++) {
			char[] charArray = br.readLine().toCharArray();
			for (int j = 0; j < 8; j++) wheels[i][j] = charArray[j] - '0';
		}
		
		int K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int target = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			
			// 현재 기준 오른쪽 체크
			int rightIdx = 3;
			for (int j = target; j < 3; j++) {
				if (wheels[j][2] == wheels[j + 1][6]) {
					rightIdx = j;
					break;
				}
			}
			// 현재 기준 왼쪽 체크
			int leftIdx = 0;
			for (int j = target; j > 0; j--) {
				if (wheels[j][6] == wheels[j - 1][2]) {
					leftIdx = j;
					break;
				}
			}
			
			// 오른쪽 회전
			for (int j = target; j <= rightIdx; j++) if ((target - j) % 2 == 0) rotateWheels(wheels, j, dir); else rotateWheels(wheels, j, -dir);
			// 왼쪽 회전
			for (int j = target - 1; j >= leftIdx; j--) if ((j - target) % 2 == 0) rotateWheels(wheels, j, dir); else rotateWheels(wheels, j, -dir);
		}
		
		int result = 0;
		for (int i = 0; i < 4; i++) if (wheels[i][0] == 1) result += (int)Math.pow(2, i);
		
		System.out.println(result);
	}
	
	public static void rotateWheels(int[][] wheels, int num, int dir) {
		if (dir == 1) rightRotate(wheels, num, dir);
		else leftRotate(wheels, num, dir);
	}

	private static void leftRotate(int[][] wheels, int num, int dir) {
		int first = wheels[num][0];
		for (int i = 0; i < 7; i++) wheels[num][i] = wheels[num][i + 1];
		wheels[num][7] = first;
	}

	private static void rightRotate(int[][] wheels, int num, int dir) {
		int last = wheels[num][7];
		for (int i = 7; i > 0; i--) wheels[num][i] = wheels[num][i - 1];
		wheels[num][0] = last;
	}
}
