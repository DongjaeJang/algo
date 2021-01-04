/**
 * 1 -> k -> X 최소 거리
 */
const n = 5;
const info = [
  [1, 2],
  [1, 3],
  [1, 4],
  [2, 4],
  [3, 4],
  [3, 5],
  [4, 5],
];
const x = 4;
const k = 5;

const n2 = 4;
const info2 = [
  [1, 3],
  [2, 4],
];
const x2 = 3;
const k2 = 4;

function solution(n, info, x, k) {
  const INF = 1e9;
  // 노드간 연결을 보여줄 2차원 배열 graph 선언
  const graph = Array.from(Array(n + 1), () => Array(n + 1).fill(INF));
  // 자기 자신은 0으로 초기화
  for (let i = 1; i < n + 1; i++) {
    for (let j = 1; j < n + 1; j++) {
      if (i === j) graph[i][j] = 0;
    }
  }
  // 연결되어있는 노드 표시 -- 양방향
  info.forEach((information) => {
    const [a, b] = information;
    graph[a][b] = 1;
    graph[b][a] = 1;
  });
  // 플로이드 워셜
  for (let k = 1; k < n + 1; k++) {
    for (let i = 1; i < n + 1; i++) {
      for (let j = 1; j < n + 1; j++) {
        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
      }
    }
  }
  const distance = graph[1][k] + graph[k][x];
  return distance >= INF ? -1 : distance;
}

console.log(solution(n2, info2, x2, k2));
