# 맵 N x M
# 움직임
# 1. 왼쪽으로 회전
# 2. 회전한 뒤 앞 칸이 안가본 곳이면 전진, 아니면 왼쪽으로 다시 회전
# 3. 네 방향 모두 갈 곳이 없다면 뒤로 후진, 만약 뒤가 바다면 break

# 맵 크기
N, M = map(int, input().split())
# 캐릭터 위치 및 방향
x, y, d = map(int, input().split())
# 맵 설정
maps = []
for _ in range(N) :
    row = list(map(int, input().split()))
    maps.append(row)

# 방향 설정
directions = [0, 1, 2, 3]
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

# 좌측으로 90도 회전
def turnLeft() :
    # 전역변수 사용
    global d, turn
    d -= 1
    # 방향이 범위를 넘을 시
    if d == -1 : d = 3
    # 회전횟수 증가
    turn += 1

# 주인공 현재 위치 표시
maps[x][y] = 2
turn = 0
count = 1
# 탐색 시작
while True :
    turnLeft()
    nextX = x + dx[d]
    nextY = y + dy[d]

    # 전진
    if maps[nextX][nextY] == 0 :
        x = nextX
        y = nextY
        maps[nextX][nextY] = 2
        turn = 0
        count += 1
        continue

    # 후진
    if turn == 4 :
        nextX = x - dx[d]
        nextY = y - dx[d]
        # 바다일 때
        if maps[nextX][nextY] == 1 :
            break
        else :
            x = nextX
            y = nextY
            turn = 0

print(count)