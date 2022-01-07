/*
 * << 다익스트라 >> --- 한 지점에서 다른 지점까지의 최단 경로
 * 구현이 쉽지만 느린 방법
 * 시간복잡도 V^2
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
const visited = Array(n1 + 1).fill(false);
const distance = Array(n1 + 1).fill(987654321);
const graph = Array.from(Array(n1 + 1), () => Array(0));

info1.forEach((v) => {
  const [start, next, weight] = v;
  graph[start].push([next, weight]);
});

const getSmallest = () => {
  let min = 987654322;
  let idx = 0;
  for (let i = 1; i < distance.length; i++) {
    if (distance[i] < min && !visited[i]) {
      min = distance[i];
      idx = i;
    }
  }
  return idx;
};

const dijkstra = (start) => {
  distance[start] = 0;
  visited[start] = true;
  for (let i = 0; i < graph[start].length; i++)
    distance[graph[start][i][0]] = graph[start][i][1];
  for (let i = 0; i < n1 - 1; i++) {
    const now = getSmallest();
    visited[now] = true;
    for (let j = 0; j < graph[now].length; j++) {
      const cost = distance[now] + graph[now][j][1];
      if (cost < distance[graph[now][j][0]]) distance[graph[now][j][0]] = cost;
    }
  }
};
dijkstra(start2);

console.log(distance);
