/*
 * << 다익스트라 >> --- 한 지점에서 다른 지점까지의 최단 경로
 * 구현이 쉽지만 느린 방법
 * 시간복잡도 V^2
 * 1. visited 배열 생성 -- 방문 체크
 * 2. distance 배열 생성 -- 거리 체크
 * 3. graph 2차원배열 생성 -- 이어진 간선 체크
 */

const n1 = 6;
const v1 = 11;
const start1 = 1;
const start2 = 2;
const info1 = [
  [1, 2, 2],
  [1, 3, 5],
  [1, 4, 1],
  [2, 3, 3],
  [2, 4, 2],
  [3, 2, 3],
  [3, 6, 5],
  [4, 3, 3],
  [4, 5, 1],
  [5, 3, 1],
  [5, 6, 2],
];

const INF = 987654321;
// 방문 체크할 배열
const visited = Array(n1 + 1).fill(false);
// 거리를 담을 배열
const distance = Array(n1 + 1).fill(INF);
// 간선 정보를 담을 배열
const graph = Array.from(Array(n1 + 1), () => Array(0));
// 간선 정보 반영
info1.forEach((information) => {
  const [start, end, cost] = information;
  graph[start].push({ end: end, cost: cost });
});
/**
 * 최소 거리 노드를 뽑는 함수
 * 처음부터 순회하면서
 * 1. 아직 방문하지 않았고
 * 2. 거리가 최소인 노드를 찾는다.
 */
const getSmallest = () => {
  let min = INF;
  let idx = 0;
  for (let i = 1; i < n1 + 1; i++) {
    if (!visited[i] && min > distance[i]) {
      min = distance[i];
      idx = i;
    }
  }
  return idx;
};

const dijkstra = (start) => {
  // 첫 노드는 거리 0
  distance[start] = 0;
  // 첫 노드는 방문처리
  visited[start] = true;
  // 첫 노드와 연결된 간선들 저장
  for (let node of graph[start]) {
    distance[node.end] = node.cost;
  }
  // 나머지 순차 진행 -- 앞에서 하나 했기 때문에 n - 1 번
  for (let i = 0; i < n1 - 1; i++) {
    const now = getSmallest();
    visited[now] = true;
    for (let node of graph[now]) {
      const cost = distance[now] + node.cost;
      if (cost < distance[node.end]) distance[node.end] = cost;
    }
  }
};

dijkstra(start1);
// [987654321, 0, 2, 3, 1, 2, 4]
console.log(distance);
