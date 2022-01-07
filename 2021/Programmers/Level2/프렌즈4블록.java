import java.io.*;
import java.util.*;

class Solution {
    // 1. 사방탐색
    // 2. 지우고
    // 3. 내리기
    // 4. 1 ~ 3 반복
    public class Position {
        int x, y;
        
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public final char EMPTY_BLOCK = '0';
    public int answer = 0;
    
    public int solution(int m, int n, String[] board) {
        char[][] newBoard = initBoard(board, m, n);
        
        while (true) {
            List<Position> positions = new ArrayList<>();
            
            for (int x = 0; x < m - 1; x++) {
                for (int y = 0; y < n - 1; y++) {
                    if (newBoard[x][y] == EMPTY_BLOCK) continue;
                    else {
                        if (checkAround(newBoard, m, n, x, y)) {
                            positions.add(new Position(x, y));
                            positions.add(new Position(x, y + 1));
                            positions.add(new Position(x + 1, y));
                            positions.add(new Position(x + 1, y + 1));
                        }
                    }
                }
            }
            
            int size = positions.size();
            if (size == 0) break;
            else {
                removeBlock(positions, newBoard);
                downBlock(newBoard, m, n);
            }
        }
        
        return answer;
    }
    
    public char[][] initBoard(String[] board, int m, int n) {
        char[][] tempBoard = new char[m][n];
        
        for (int x = 0; x < m; x++) {
            tempBoard[x] = board[x].toCharArray();
        }
        
        return tempBoard;
    }
    
    // 범위 체크
    public boolean outOfRange(int m, int n, int x, int y) {
        if (x < 0 || y < 0 || x == m || y == n) return true;
        else return false;
    }
    
    // 사방 탐색
    public boolean checkAround(char[][] board, int m, int n, int x, int y) {
        char block = board[x][y];
        
        int[] dx = {0, 1, 1};
        int[] dy = {1, 0, 1};
        
        for (int d = 0; d < 3; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if (outOfRange(m, n, nx, ny) || board[nx][ny] != block) return false;
        }
        return true;
    }
    
    // 지우기
    public void removeBlock(List<Position> positions, char[][] board) {
        for (int i = 0; i < positions.size(); i++) {
            Position current = positions.get(i);
            
            if (board[current.x][current.y] != EMPTY_BLOCK) {
                board[current.x][current.y] = EMPTY_BLOCK;
                answer++;
            }
        }
    }
    
    // 내리기 - '빈칸' : 'O'
    public void downBlock(char[][] board, int m, int n) {
        for (int y = 0; y < n; y++) {
            for (int x = m - 1; x >= 0; x--) {
                if (board[x][y] != EMPTY_BLOCK) {
                    int nx = x;
                    final char CURRENT_BLOCK = board[x][y];
                    while (true) {
                        if (outOfRange(m, n, nx + 1, y) || board[nx + 1][y] != EMPTY_BLOCK) break;
                        board[nx][y] = EMPTY_BLOCK;
                        board[++nx][y] = CURRENT_BLOCK;
                    }
                }
            }
        }
    }
}