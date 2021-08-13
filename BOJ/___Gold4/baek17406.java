package day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int permuCount = 0;
	static List<int[]> permuList = new ArrayList<>();
	static boolean[] isSelected;
	static int[] numbers;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 행
		int M = Integer.parseInt(st.nextToken()); // 열
		int K = Integer.parseInt(st.nextToken()); // 횟수

		// 보드 생성
		int[][] board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 순열 생성
		List<int[]> operationList = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int tempR = Integer.parseInt(st.nextToken()) - 1;
			int tempC = Integer.parseInt(st.nextToken()) - 1;
			int tempS = Integer.parseInt(st.nextToken());
			
			operationList.add(new int[] {tempR, tempC, tempS});	// 저장 순서 -> r, c, s
		}
		isSelected = new boolean[K];
		numbers = new int[K];
		
		permutation(0);
		
		// 돌면서 체크
		for (int j = 0; j < permuCount; j++) {
			int[][] tempBoard = new int[N][M];	// 본래 배열 카피
			for (int i = 0; i < N; i++) {
				tempBoard[i] = Arrays.copyOf(board[i], board[i].length);
			}
			int[] tempOrder = permuList.get(j);	// 순열 순서
			for (int i = 0; i < K; i++) {
				int[] op = operationList.get(tempOrder[i]);	// 몇번째를 가져올지
				
				int startN = op[0] - op[2];	// x 좌표 시작점
				int startM = op[1] - op[2];	// y 좌표 시작점
				int tempCount = 2 * op[2] + 1;	// 정사각형 길이 체크
						
				int count = tempCount / 2;	// pivot 갯수
				rotateBoard(tempBoard, startN, startM, tempCount, count);
			}
			
			// 최솟값 탐색
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int k = 0; k < M; k++) {
					sum += tempBoard[i][k];
				}
				min = Math.min(sum, min);	// 최솟값 업데이트
			}
		}
		
		System.out.println(min);
	}
	// 순열 생성
	private static void permutation(int count) {
		if (count == isSelected.length) {
			permuCount++;
			int[] permu = Arrays.copyOf(numbers, numbers.length);
			permuList.add(permu);
		}
		
		for (int i = 0; i < isSelected.length; i++) {
			if (isSelected[i]) continue;
			isSelected[i] = true;
			numbers[count] = i;
			permutation(count + 1);
			isSelected[i] = false;
		}
	}
	// 배열 돌리기
	private static void rotateBoard(int[][] board, int startN, int startM, int N, int count) {
		for (int i = 0; i < count; i++) {
			int row = startN + i, col = startM + i;	// start point 지정
			int nx, ny;
			int startValue = board[row][col];	// 마지막에 덮어쓸 수 저장
			
			for (int d = 0; d < 4; d++) {
				for (int j = 0; j < (N - i * 2) - 1; j++) {
					nx = row + dx[d];
					ny = col + dy[d];
					board[row][col] = board[nx][ny];
					row = nx;
					col = ny;
				}
			}
			board[row - dx[3]][col - dy[3]] = startValue;	// 마지막에 엎어쓰기한 수 체크
		}
	}
}
