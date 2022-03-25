package practice;

import java.io.*;
import java.util.*;

public class BOJ3190 {
	public static final int EMPTY = 0;	// 빈 칸
	public static final int SNAKE = 1;	// 몸통
	public static final int APPLE = 2;	// 사과
	
	public static int[] dx = {0, 1, 0, -1};	// 이동
	public static int[] dy = {1, 0, -1, 0};	// 이동
	
	public static int N, K, L;	// 보드 크기, 사과 개수, 방향 변환 횟수
	public static int second;	// 걸린 시간
	public static int[][] board;	// 보드
	public static int[] moves;	// 방향 변환 시간 정보
	public static char[] directions;	// 방향 변환 정보
	
	public static int headX, headY, tailX, tailY;	// 머리 좌표, 꼬리 좌표
	public static int direction;	// 현재 방향
	public static Queue<int[]> body;	// 몸통 위치 정보
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 변수 초기화 및 업데이트
		N = Integer.parseInt(br.readLine()); K = Integer.parseInt(br.readLine());
		board = new int[N][N];
		board[0][0] = SNAKE;
		// 사과 위치 업데이트
		StringTokenizer st;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken()) - 1;
			int col = Integer.parseInt(st.nextToken()) - 1;
			
			board[row][col] = APPLE;
		}
		// 방향 변환 정보 업데이트
		L = Integer.parseInt(br.readLine());
		moves = new int[L]; directions = new char[L];
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int sec = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			
			moves[i] = sec; directions[i] = dir;
		}
		// 변수 초기화
		headX = 0; headY = 0; tailX = 0; tailY = 0;
		direction = 0;
		second = 0;
		body = new LinkedList<>();
		body.offer(new int[] {headX, headY});	// 뱀 몸통 시작값 추가
		
		int moveIdx = 0;	// 방향 변환 횟수 인덱스 선언
		
		while (true) {
			// 방향 변환 횟수가 남았고, 이전 시간이 방향 변환 시간일 때
			if (moveIdx < L && second == moves[moveIdx]) {
				if (directions[moveIdx] == 'L') {	// 좌측
					direction -= 1;
					if (direction < 0) direction += 4;
				} else {	// 우측
					direction += 1;
					if (direction == 4) direction %= 4;
				}
				moveIdx++;	// 인덱스 증가
			}
			second++;	// 시간 증가
			// 다음 진행 좌표
			int nextX = headX + dx[direction];
			int nextY = headY + dy[direction];
			// 벽에 부딪히거나 몸통에 박았을 때 탈출
			if (outOfRange(nextX, nextY) || board[nextX][nextY] == SNAKE) break;
			// 머리 좌표 업데이트
			headX = nextX; headY = nextY;
			body.offer(new int[] {headX, headY});	// 몸통에 추가
			
			if (board[headX][headY] == EMPTY) {	// 빈 공간이면 꼬리가 줄어든다
				board[tailX][tailY] = EMPTY;	// 빈 공간으로 변경
				body.poll();	// 몸통에서 제거
				
				int[] peek = body.peek();	// 몸통 마지막 위치
				tailX = peek[0]; tailY = peek[1];	// 꼬리 위치 업데이트
			}
			board[headX][headY] = SNAKE;	// 진행 방향 업데이트
		}
		
		System.out.println(second);
	}
	
	public static boolean outOfRange(int x, int y) {
		if (x < 0 || x == N || y < 0 || y == N) return true;
		return false;
	}
}
