def solution(n):
    # 최댓값
    max = 0
    for i in range(n + 1):
        max += i
    # 배열 초기화
    answer = []
    for i in range(1, n + 1):
        temp = []
        for j in range(i):
            temp.append(0)
        answer.append(temp)
    # 이동방향 - 아래, 오른쪽, 왼쪽 대각선 위
    dx = [1, 0, -1]
    dy = [0, 1, -1]
    idx = 0
    # 시작 위치
    x, y = 0, 0
    num = 1
    # 배열 순회
    while num <= max:
        answer[x][y] = num
        num += 1
        # 다음 값
        nx = x + dx[idx]
        ny = y + dy[idx]
        # 접근 못하는 곳이면 idx 증가
        if nx < 0 or nx == n or ny < 0 or ny == n or (answer[nx][ny] != 0):
            idx += 1
            if idx == 3: idx -= 3
        nx = x + dx[idx]
        ny = y + dy[idx]
        x = nx
        y = ny

    result = []
    # 하나씩 결과 배열에 추가
    for i in range(n):
        for j in range(i + 1):
            result.append(answer[i][j])

    return result

print(solution(6))