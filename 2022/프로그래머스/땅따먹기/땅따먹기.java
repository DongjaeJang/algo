import java.util.*;

class Solution {
    final int SIZE = 4; // 땅 4칸
    
    int solution(int[][] land) {
        int height = land.length;   // 길이

        int[][] dp = new int[height][SIZE]; // dp할 배열 선언
        for (int i = 0; i < SIZE; i++) dp[0][i] = land[0][i];   // 첫줄 초기화
        
        for (int i = 1; i < height; i++) {
            for (int j = 0; j < SIZE; j++) {
                int a = (j + 1) >= SIZE ? (j + 1) % SIZE : (j + 1); // 다음 열
                int b = (j + 2) >= SIZE ? (j + 2) % SIZE : (j + 2); // 다다음 열
                int c = (j + 3) >= SIZE ? (j + 3) % SIZE : (j + 3); // 다다다음 열
                dp[i][j] = land[i][j] + Math.max(dp[i - 1][a], Math.max(dp[i - 1][b], dp[i - 1][c]));   // 밟고 있는 칸 + 바로 윗칸 말고 최댓값
            }
        }

        return Arrays.stream(dp[height - 1]).max().getAsInt();  // 마지막 행 최댓값 리턴
    }
}