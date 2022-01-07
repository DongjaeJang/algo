/**
 * << 플로이드 워셜 >> --- 모든 지점에서 다른 모든 지점까지의 최단 경로
 * 시간복잡도 : V^3
 * 기본 점화식 : Dab = min(Dab, Dak + Dkb)
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

// 2차원 배열 초기화
const graph = Array.from(Array(n1 + 1), () => Array(n1 + 1).fill(987654321));
// 본인에서 본인(a->a) 는 0으로 초기화
for (let i = 1; i < n1 + 1; i++) {
  for (let j = 1; j < n1 + 1; j++) if (i === j) graph[i][j] = 0;
}
// info를 통해 값 반영
for (let i = 0; i < info1.length; i++) {
  const [a, b, w] = info1[i];
  graph[a][b] = w;
}
// 점화식에 따라 플로이드 워셜 알고리즘 수행
for (let k = 1; k < n1 + 1; k++) {
  for (let i = 1; i < n1 + 1; i++) {
    for (let j = 1; j < n1 + 1; j++) {
      graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
    }
  }
}
for (let i = 1; i < n1 + 1; i++) console.log(graph[i]);

/**
 * 0 4 8 6
 * 3 0 7 9
 * 5 9 0 4
 * 7 11 2 0
 */
