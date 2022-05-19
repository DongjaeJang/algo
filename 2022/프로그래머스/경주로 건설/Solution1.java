package nf;

import java.io.*;
import java.util.*;

class Solution {
    /**
        직선 100원, 코너 500원
        시작할 때, 아래 혹은 우측 시작 두가지로
        dfs 진행
    */
    public int N;
    public int answer;
    
    public int[] dx = {0, -1, 0, 1};
    public int[] dy = {1, 0, -1, 0};
    
    public final int LINE = 100;
    public final int CURVE = 500;
    
    public int[][][] cost;
    
    public int solution(int[][] board) {
        N = board.length;
        
        answer = Integer.MAX_VALUE;
        cost = new int[N][N][4];
        
        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) Arrays.fill(cost[i][j], Integer.MAX_VALUE);
        
        dfs(board, -1, 0, 0, 0);
        
        return answer;
    }
    
    public void dfs(int[][] board, int dir, int x, int y, int money) {
        if (x == N - 1 && y == N - 1) {
            if (answer > money) {
                answer = money;
            }
            return;
        }
        
        board[x][y] = 2;
        
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            
            if (outOfRange(nx, ny) || board[nx][ny] != 0) continue;
            
            if (dir == -1) {
                if (d == 1 || d == 2) continue;
                else {
                    cost[nx][ny][d] = money + LINE;
                    dfs(board, d, nx, ny, money + LINE);
                    board[nx][ny] = 0;
                }
            } else {
                int tempMoney = money + LINE + (d % 2 != dir % 2 ? CURVE : 0) ;
                if (tempMoney >= answer || cost[nx][ny][d] < tempMoney) continue;
                
                cost[nx][ny][d] = tempMoney;
                dfs(board, d, nx, ny, tempMoney);
                board[nx][ny] = 0;
            }
        }
    }
    
    public boolean outOfRange(int x, int y) {
        if (x < 0 || y < 0 || x == N || y == N) return true;
        return false;
    }
}