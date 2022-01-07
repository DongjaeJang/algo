const n = 5;
const info = [
  [1, 2, 2],
  [1, 3, 3],
  [1, 4, 1],
  [1, 5, 10],
  [2, 4, 2],
  [3, 4, 1],
  [3, 5, 1],
  [4, 5, 3],
  [3, 5, 10],
  [3, 1, 8],
  [1, 4, 2],
  [5, 1, 7],
  [3, 4, 2],
  [5, 2, 4],
];

function solution(n, info) {
  const INF = 1e9;
  const graph = Array.from(Array(n + 1), () => Array(n + 1).fill(INF));
  // 자기 자신 0
  for (let i = 1; i <= n; i++) {
    for (let j = 1; j <= n; j++) if (i === j) graph[i][j] = 0;
  }
  // 간선정보 추가
  info.forEach((information) => {
    const [a, b, cost] = information;
    graph[a][b] = Math.min(graph[a][b], cost);
  });
  // 플로이드 워셜
  for (let k = 1; k < n + 1; k++) {
    for (let i = 1; i < n + 1; i++) {
      for (let j = 1; j < n + 1; j++) {
        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
      }
    }
  }
  console.log(graph[1]);
  return graph;
}

console.log(solution(n, info));
