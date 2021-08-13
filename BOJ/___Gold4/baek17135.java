package day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 조합 생성
		int[] positions = new int[M];
		for (int i = 0; i < 3; i++) positions[M - i - 1] = 1;
		
		int count = 0;
		do {
			count = Math.max(count, playGame(board, positions, N, M, D));
		} while (nextPermutation(positions));
		
		System.out.println(count);
	}
	
	// 위치마다 한번씩 체크
	private static int playGame(int[][] board, int[] positions, int N, int M, int D) {
		int count = 0;	// 제거 횟수
		int[][] copyBoard = new int[N][M];
		for (int i = 0; i < N; i++) // 맵 카피
			copyBoard[i] = Arrays.copyOf(board[i], M);
		
		int[] archer = new int[3];	// 궁수 column
		int idx = 0;
		for (int i = 0; i < M; i++)
			if (positions[i] == 1) archer[idx++] = i; 
		
		while (monsterCheck(copyBoard, N, M)) {
			int[][] attackPos = new int[3][3];	// 아처 위치정보를 담을 배열
			updateAttackPos(copyBoard, attackPos, N, M, archer);	// 아처 위치정보 업데이트
			count += deleteMonster(copyBoard, attackPos, D);	// 몬스터 삭제
			moveMonster(copyBoard, N, M);	// 몬스터 이동
		}
		
		return count;
	}
	
	// 몬스터가 맵에 남아있는지 체크
	private static boolean monsterCheck(int[][] board, int N, int M) {
		boolean monsterCheck = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1) {
					monsterCheck = true;
					break;
				}
			}
		}
		return monsterCheck;
	}
	
	// 궁수가 죽일 수 몬스터 위치 정보
	private static void updateAttackPos(int[][] board, int[][] attackPos, int N, int M, int[] archers) {
		for (int i = 0; i < 3; i++) {	// 궁수 세명 체크
			int minDistance = Integer.MAX_VALUE;
			for (int row = 0; row < N; row++) {	// 맵 우측 상단부터 최소거리 체크
				for (int col = 0; col < M; col++) {
					if (board[row][col] == 1) {	// 적이라면
						int tempDistance = Math.abs(N - row) + Math.abs(archers[i] - col);
						if (minDistance > tempDistance) {	// 거리가 더 작다면 바로 업데이트
							minDistance = tempDistance;
							attackPos[i][0] = row;
							attackPos[i][1] = col;
							attackPos[i][2] = tempDistance;
						} else if (minDistance == tempDistance && col < attackPos[i][1]) {	// 같다면 컬럼이 작을 때만 업데이트
							minDistance = tempDistance;
							attackPos[i][0] = row;
							attackPos[i][1] = col;
							attackPos[i][2] = tempDistance;
						}
					}	
				}
			}
		}
	}

	// 몬스터 제거
	private static int deleteMonster(int[][] board, int[][] attackPos, int D) {
		int count = 0;
		for (int i = 0; i < 3; i++) {	// 맵에서 몬스터 지우기
			if ((board[attackPos[i][0]][attackPos[i][1]] == 1) && (attackPos[i][2] <= D)) {	// 거리가 사정거리 안에 들어오면 제거
				count++;
				board[attackPos[i][0]][attackPos[i][1]] = 0;
			}
		}
		return count;
	}
	
	// 몬스터 이동
	private static void moveMonster(int[][] board, int N, int M) {
		for (int i = N - 1; i > 0; i--)
			board[i] = Arrays.copyOf(board[i - 1], M);
		board[0] = new int[M];
	}
	
	// 조합 생성
	private static boolean nextPermutation(int[] numbers) {
		int N = numbers.length;
		// 꼭대기 (i) 찾기
		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i]) --i;
		if (i == 0) return false;

		// 교환 값 찾기
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j]) --j;

		// 교환
		swap(numbers, i - 1, j);

		// 오름차순으로 처리
		int k = N - 1;
		while (i < k) swap(numbers, i++, k--);
		return true;
	}
	
	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
