package boj_self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ20056 {
	public static class FireBall {
		int x, y;
		int m, s, d;
		
		public FireBall(int x, int y, int m, int s, int d) {
			this.x = x;
			this.y = y;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		
		List<FireBall> fbList = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1, c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
			fbList.add(new FireBall(r, c, m, s, d));
		}

		for (int i = 0; i < K; i++) {
			int[][] checked = new int[N][N];
			
			// 모든 파이어볼 자신의 속도에 맞게 이동
			for (int j = 0; j < fbList.size(); j++) {
				FireBall fb = fbList.get(j);
				
				int finalX = fb.x + dx[fb.d] * (fb.s % N);
				int finalY = fb.y + dy[fb.d] * (fb.s % N);
				
                if (finalX > 0) finalX %= N;
                if (finalY > 0) finalY %= N;
                if (finalX < 0) finalX = N - Math.abs(finalX);
                if (finalY < 0) finalY = N - Math.abs(finalY);
				
				fbList.get(j).x = finalX;
				fbList.get(j).y = finalY;
				
				checked[finalX][finalY]++;
			}
			
			for (int j = 0; j < N; j++) { 
				for (int k = 0; k < N; k++) {
					if (checked[j][k] > 1) {	// 한 곳에 여러개 있을 때
						List<FireBall> delList = new ArrayList<>();
						for (int g = fbList.size() - 1; g >= 0; g--) {
							if (fbList.get(g).x == j && fbList.get(g).y == k) 
								delList.add(fbList.remove(g));
						}
						
						int tempM = 0;
						int tempS = 0;
						int[] dirs = new int[8];
						
						for (int g = 0; g < delList.size(); g++) {
							tempM += delList.get(g).m;
							tempS += delList.get(g).s;
							
							dirs[delList.get(g).d]++;
						}
						
						tempM /= 5;
						tempS /= checked[j][k];
						
						if (tempM == 0) continue;
						
						if ((dirs[0] == 0 && dirs[2] == 0 && dirs[4] == 0 && dirs[6] == 0) || (dirs[1] == 0 && dirs[3] == 0 && dirs[5] == 0 && dirs[7] == 0)) {
							for (int g = 0; g < 8; g += 2) {
								fbList.add(new FireBall(j, k, tempM, tempS, g));
							}
						} else {
							for (int g = 1; g < 8; g += 2) {
								fbList.add(new FireBall(j, k, tempM, tempS, g));
							}
						}
					}
				}
			}
		}
		int result = 0;
		for (int i = 0; i < fbList.size(); i++) result += fbList.get(i).m;
		
		System.out.println(result);
	}
}
