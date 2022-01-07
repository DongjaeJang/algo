import pprint as pp  # 2차원 배열 이쁘게 뽑기

n, m = map(int, input().split())    # 노드 n, 간선 m
INF = int(1e9)
# 자기 자신은 0으로, 나머지는 INF로 초기화
graph = [[INF if i != j else 0 for j in range(n+1)] for i in range(n+1)]

for _ in range(m):  # 간선 정보 입력 뒤 업데이트
    a, b = map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = 1

x, k = map(int, input().split())    # 목적지와 경유지

for k in range(1, n + 1):   # 플로이드 워셜
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

pp.pprint(graph)    # graph 정보 잘 들어갔는지 확인
distance = graph[1][k] + graph[k][x]    # distance 저장

# distance가 INF보다 작을 때는 그대로 내보내고 아닌 경우 -1 출력
print(distance if distance <= INF else -1)
