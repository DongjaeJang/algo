N, M = map(int, input().split())
maps = []
# 맵 설정
for _ in range(N) :
    temp = list(map(int, input()))
    maps.append(temp)
# 상하좌우
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]
# 탐색 함수
def dfs(x, y) :
    global maps, dx, dy
    if maps[x][y] == 1:
        return
    maps[x][y] = 1

    for i in range(4) :
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < M :
            dfs(nx, ny)

    return True

count = 0
# 탐색 시작
for i in range(N) :
    for j in range(M) :
        if dfs(i, j) == True : count += 1

print(count)