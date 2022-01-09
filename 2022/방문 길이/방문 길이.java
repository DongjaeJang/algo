class Solution {
    private final int DIR_SIZE = 4; // 방향 4가지
    private final int MAX_LENGTH = 11;  // 맵 크기
    private final String UDLR = "UDLR"; // 방향 잡기
    
    private boolean[][][] board;    // 맵
    private int x, y;   // 시작점
    private int answer; // 정답 체크용

    private int[] dx = {-1, 1, 0, 0};   // x좌표 이동
    private int[] dy = {0, 0, -1, 1};   // y좌표 이동
    // 맵 및 전역변수 초기화
    private void initBoard() {
        this.board = new boolean[this.MAX_LENGTH][this.MAX_LENGTH][this.DIR_SIZE];  // 맵크기 x 맵크기 x 방향
        this.x = 5;
        this.y = 5;
        this.answer = 0;
    }
    // 맵 범위 체크
    private boolean outOfRange(int nx, int ny) {
        if (nx < 0 || ny < 0 || nx == MAX_LENGTH || ny == MAX_LENGTH) return true;
        return false;
    }
    // 이동 함수
    private void go(int direction) {
        int nx = this.x + this.dx[direction];   // 다음 x좌표
        int ny = this.y + this.dy[direction];   // 다음 y좌표   
        
        if (this.outOfRange(nx, ny)) return;    // 맵 범위 넘으면 탈출
        // 해당 좌표로 향한 기록도 없고 돌아온 기록도 없다면 처음 가는 길
        if (!this.board[x][y][direction] && !this.board[nx][ny][direction % 2 == 0 ? direction + 1 : direction - 1]) this.answer++;
        this.board[x][y][direction] = true; // 이동 체크
        
        this.x = nx;    // 좌표 이동
        this.y = ny;    // 좌표 이동
    }
    
    public int solution(String dirs) {
        char[] dirsArray = dirs.toCharArray();

        this.initBoard();
        
        for (char dir : dirsArray) {
            int direction = -1;
            for (int i = 0; i < this.DIR_SIZE; i++) {
                if (dir == UDLR.charAt(i)) {
                    direction = i;
                    break;
                }
            }
            this.go(direction);
        }
        
        return this.answer;
    }
}