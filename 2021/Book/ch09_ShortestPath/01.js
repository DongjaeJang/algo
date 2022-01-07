const n1 = 5;
const x1 = 4;
const k1 = 5;
const info1 = [
  [1, 2],
  [1, 3],
  [1, 4],
  [2, 4],
  [3, 4],
  [3, 5],
  [4, 5],
];
const n2 = 4;
const x2 = 3;
const k2 = 4;
const info2 = [
  [1, 3],
  [2, 4],
];

function solution(n, x, k, info) {
  // 2차원 배열 선언 -- 초기값 10억
  const INF = 987654321;
  const graph = Array.from(Array(n + 1), () => Array(n + 1).fill(INF));
  // 본인 노드는 0으로
  for (let i = 1; i < n + 1; i++) {
    for (let j = 1; j < n + 1; j++) {
      if (i === j) graph[i][j] = 0;
    }
  }
  // 주어진 정보에 따라 배열 갱신
  info.forEach((v) => {
    const [start, next] = v;
    graph[start][next] = 1;
    graph[next][start] = 1;
  });

  // 플로이드 워셜 진행
  for (let k = 1; k < n + 1; k++) {
    for (let i = 1; i < n + 1; i++) {
      for (let j = 1; j < n + 1; j++) {
        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
      }
    }
  }
  const distance = graph[1][k] + graph[k][x];
  if (distance >= INF) return -1;
  else return distance;
}

console.log(solution(n2, x2, k2, info2));
