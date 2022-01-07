import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("/Users/dj/Desktop/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		// N극 0 , S극 1
		// S극일 때만 점수 (int)Math.pow(2, i);
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());
			int[][] magnets = new int[4][8];
			
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnets[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int result = 0;
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int target = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());

				// 우측 체크
				int rightIdx = 3;
				for (int j = target; j < 3; j++) {
					if (magnets[j][2] == magnets[j + 1][6]) {
						rightIdx = j;
						break;
					}
				}
				// 좌측 체크
				int leftIdx = 0;
				for (int j = target; j > 0; j--) {
					if (magnets[j][6] == magnets[j - 1][2]) {
						leftIdx = j;
						break;
					}
				}
				
				if (dir == 1) {
					for (int j = target; j <= rightIdx; j++) {
						if ((j - target) % 2 == 0) shiftRight(magnets[j]); 
						else shiftLeft(magnets[j]);
					}

					for (int j = target - 1; j >= leftIdx; j--) {
						if ((target - j) % 2 == 0) shiftRight(magnets[j]); 
						else shiftLeft(magnets[j]);
					}
				} else {
					for (int j = target; j <= rightIdx; j++) {
						if ((j - target) % 2 == 1) shiftRight(magnets[j]); 
						else shiftLeft(magnets[j]);
					}
					
					for (int j = target - 1; j >= leftIdx; j--) {
						if ((target - j) % 2 == 1) shiftRight(magnets[j]); 
						else shiftLeft(magnets[j]);
					}
				}
			}
			// 점수 추가
			for (int j = 0; j < 4; j++) if (magnets[j][0] == 1) result += (int)Math.pow(2, j);
			
			answer.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(answer);
	}
	
	// 반시계 : -1
	public static void shiftLeft(int[] array) {
		int temp = array[0];
		for (int i = 0; i < 7; i++) array[i] = array[i + 1];
		array[7] = temp;
	}
	// 시계 : 1
	public static void shiftRight(int[] array) {
		int temp = array[7];
		for (int i = 7; i > 0; i--) array[i] = array[i - 1];
		array[0] = temp;
	}
}
