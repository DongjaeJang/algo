/**
 * << 플로이드 워셜 >> --- 모든 지점에서 다른 모든 지점까지의 최단 경로
 * 시간복잡도 : V^3
 * 기본 점화식 : Dab = min(Dab, Dak + Dkb)
 *
 * 1. 2차원 행렬을 만들고, 초기값을 모두 무한대로 설정
 * 2. 자기 자신은 0으로 설정하고, 주어진 간선 정보를 반영
 * 3. 기존 루트가 빠른지 다른 길을 연결해서 가는게 빠른지 최솟값 비교
 */
const n1 = 4;
const info1 = [
  [1, 2, 4],
  [1, 4, 6],
  [2, 1, 3],
  [2, 3, 7],
  [3, 1, 5],
  [3, 4, 4],
  [4, 3, 2],
];
// 2차원 행렬 초기화
const INF = 987654321;
const graph = Array.from(Array(n1 + 1), () => Array(n1 + 1).fill(INF));
// 자기 자신은 0으로
for (let i = 1; i < n1 + 1; i++) {
  for (let j = 1; j < n1 + 1; j++) if (i === j) graph[i][j] = 0;
}
// edge 정보 반영
info1.forEach((information) => {
  const [start, end, cost] = information;
  graph[start][end] = cost;
});

// 플로이드 워셜 수행
for (let k = 1; k < n1 + 1; k++) {
  for (let i = 1; i < n1 + 1; i++) {
    for (let j = 1; j < n1 + 1; j++) {
      graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
    }
  }
}

/**
 * 0 4 8 6
 * 3 0 7 9
 * 5 9 0 4
 * 7 11 2 0
 */

console.log(graph);
