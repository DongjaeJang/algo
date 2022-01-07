import pprint as pp
import heapq

n, m, c = map(int, input().split())  # 노드, 간선, 도시
INF = int(1e9)
graph = [[] for _ in range(n+1)]    # 정보를 담을 배열 graph
distance = [INF] * (n+1)    # 거리를 담을 distance를 INF 값으로 초기화


for _ in range(m):  # 간선 정보 입력받기
    x, y, z = map(int, input().split())
    graph[x].append((y, z))  # 출발점x에 도착점y와 cost를 튜플 형태로 추가


def dijkstra(start):
    queue = []
    heapq.heappush(queue, (0, start))   # 우선순위큐를 만들고 (cost, 시작점) 추가
    distance[start] = 0  # 시작점 cost = 0

    while queue:
        dist, now = heapq.heappop(queue)    # 우선순위큐에서 하나 빼줌
        if distance[now] < dist:    # 현재 distance가 저장되어있는 distance보다 더 크면 skip
            continue
        for i in graph[now]:    # 현재 연결되어 있는 노드 순회
            cost = dist + i[1]  # 거리가 1이므로 dist + 1

            # 현재 distance(cost)가 저장되어있는 distance보다 작으면
            if cost < distance[i[0]]:
                distance[i[0]] = cost   # distance 업데이트
                heapq.heappush(queue, (cost, i[0]))  # 큐에 추가


dijkstra(c)
pp.pprint(distance)

count = 0   # 개수
max_distance = 0    # 가장 먼거리

for dist in distance:
    if dist != INF:  # INF가 아니라면 카운트
        count += 1
        max_distance = max(max_distance, dist)

print(count - 1, max_distance)  # 자기 자신은 빼야되므로
