package nf;

import java.io.*;
import java.util.*;

class Solution {
    public final char STRAIGHT = 'S';
    public final char RIGHT = 'R';
    public final char LEFT = 'L';

    public int R,C;
    public int[] dr = {-1,0,1,0};
    public int[] dc = {0,-1,0,1};
    
    public boolean[][][] check;
    public List<Integer> dist;
    
    public int[] solution(String[] grid) {
        R = grid.length;    // 행
        C = grid[0].length();   // 열
        
        check = new boolean[R][C][4];  // 보드 넘나드는 것 방향별 기록
        dist = new ArrayList();  // 거리
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (int d = 0; d < 4; d++) {
                    if (check[i][j][d]) continue;
                    start(grid, i, j, d);
                }
            }
        }
        
        return dist.stream().sorted().mapToInt(i -> i).toArray();
    }
    
    public void start(String[] grid, int r, int c, int d) {
        int cnt = 0;

        while(true){
            if(check[r][c][d]) break;

            cnt++;
            check[r][c][d] = true;

            if(grid[r].charAt(c) == 'L')
                d = d == 0 ? 3 : d-1;
            else if(grid[r].charAt(c) == 'R')
                d = d == 3 ? 0 : d+1;

            r = (r + dr[d] +R) %R;
            c = (c + dc[d] + C) % C;
        }

        dist.add(cnt);
    }
}