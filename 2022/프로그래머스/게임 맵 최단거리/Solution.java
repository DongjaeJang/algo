import java.io.*;
import java.util.*;

class Solution {
    public int[] dx = {-1, 1, 0, 0};
    public int[] dy = {0, 0, -1, 1};
    
    public int N, M;
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        
        bfs(maps);
        
        return maps[N - 1][M - 1] != 1 ? maps[N - 1][M - 1] : -1;
    }
    
    public void bfs(int[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int c = current[2];
            
            if (board[x][y] != 1) continue;
            board[x][y] = c;
            
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (outOfRange(nx, ny) || board[nx][ny] != 1) continue;
                queue.offer(new int[]{nx, ny, c + 1});
            }
        }
    }
    
    public boolean outOfRange(int x, int y) {
        if (x < 0 || y < 0 || x == N || y == M) return true;
        return false;
    }
}