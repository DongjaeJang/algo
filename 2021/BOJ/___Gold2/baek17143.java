package day27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	
	public static class Shark {
		int index;
		int x, y;
		int speed, direction, size;
		
		public Shark (int index, int x, int y, int speed, int direction, int size) {
			this.index = index;
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.direction = direction;
			this.size = size;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[R][C];
		List<Shark> sharkList = new ArrayList<>();
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());

			s = s % (2 * (d < 2 ? R : C) - 2);	// 스피드 패턴
			
			board[r][c] = i;
			sharkList.add(new Shark(i, r, c, s, d, z));
		}
		
		int result = 0;
		int col = -1;
		
		while (++col < C) {
			// 1. 가장 가까운 상어 잡기
			int sharkIndex = findNearestIndex(board, R, col);	// 가장 가까운 상어 인덱스
			if (sharkIndex > 0) {
				int idx = catchSharkSize(sharkList, sharkIndex);	// 샤크리스트에서 해당 인덱스 찾기
				result += sharkList.get(idx).size;	// 사이즈만큼 늘려주기
				sharkList.remove(idx);	// 삭제
			}
			// 2. 상어 무빙
			moveShark(board, R, C, sharkList);
		}
		
		System.out.println(result);
	}
	
	public static int findNearestIndex (int[][] board, int R, int col) {
		for (int i = 0; i < R; i++) {
			if (board[i][col] > 0) {
				int idx = board[i][col];
				board[i][col] = 0;	// 맵에서 삭제
				return idx;
			}
		}
		return 0;
	}
	
	public static int catchSharkSize (List<Shark> sharkList, int index) {
		for (int i = 0; i < sharkList.size(); i++) {
			if (sharkList.get(i).index == index) return i;
		}
		return -1;
	}
	
	public static void moveShark (int[][] board, int R, int C, List<Shark> sharkList) {
		List<int[]> moveList = new ArrayList<>();
		
		for (int i = 0; i < sharkList.size(); i++) {
			Shark currentShark = sharkList.get(i);
			
			board[currentShark.x][currentShark.y] = 0;	// 처음 위치 초기화
			
			int nextX = currentShark.x;
			int nextY = currentShark.y;
			for (int j = 0; j < currentShark.speed; j++) {
				if (outOfRange(R, C, nextX + dx[currentShark.direction], nextY + dy[currentShark.direction])) {	// 끝까지 가면 다시
					currentShark.direction = (currentShark.direction % 2 == 0) ? currentShark.direction + 1 : currentShark.direction - 1;	// 방향 반대로
				}
				nextX += dx[currentShark.direction];
				nextY += dy[currentShark.direction];
			}
			
			sharkList.get(i).x = nextX;
			sharkList.get(i).y = nextY;
			sharkList.get(i).direction = currentShark.direction;
			moveList.add(new int[] {nextX, nextY, currentShark.index, currentShark.size});	// 최종 이동 장소 담기 (x좌표, y좌표, 인덱스, 크기);
		}
		
		for (int i = 0; i < moveList.size(); i++) {
			int[] currentMove = moveList.get(i);
			
			int r = currentMove[0];
			int c = currentMove[1];
			int idx = currentMove[2];
			int size = currentMove[3];
			
			if (board[r][c] == 0) {	// 이동 장소에 아무도 없음
				board[r][c] = idx;
				continue;
			}
			
			int currentIdx = catchSharkSize(sharkList, board[r][c]);
			int currentSize = sharkList.get(currentIdx).size;
			
			if (currentSize < size) {	// 이동하는 애가 더 큼
				int deleteIdx = board[r][c];
				
				int deleteSharkIdx = catchSharkSize(sharkList, deleteIdx);	// 기존 샤크 인덱스
				sharkList.remove(deleteSharkIdx);	// 제거
				
				board[r][c] = idx;
			} else if (currentSize > size) {	// 기존 애가 더 큼
				int deleteSharkIdx = catchSharkSize(sharkList, idx);	// 현재 샤크 인덱스
				sharkList.remove(deleteSharkIdx);	// 제거
			}
		}
	}
	
	public static boolean outOfRange(int R, int C, int x, int y) {
		if (x < 0 || y < 0 || x == R || y == C) return true;
		return false;
	}
}
