from collections import deque

N, M = map(int, input().split())
maps = []
for _ in range(N) :
    temp = list(map(int, input()))
    maps.append(temp)

x, y = 0, 0
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs (x, y) :
    queue = deque()
    queue.append([x, y])

    while queue :
        curX, curY = queue.popleft()
        for i in range(4) :
            nx = curX + dx[i]
            ny = curY + dy[i]

            if 0 <= nx < N and 0 <= ny < M :
                if maps[nx][ny] == 0 :
                    continue
                if maps[nx][ny] == 1 :
                    maps[nx][ny] = maps[curX][curY] + 1
                    queue.append([nx, ny])

    return maps[N-1][M-1]

print(bfs(0, 0))