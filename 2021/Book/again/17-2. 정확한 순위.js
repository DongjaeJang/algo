const n = 6;
const info = [
  [1, 5],
  [3, 4],
  [4, 2],
  [4, 6],
  [5, 2],
  [5, 4],
];

function solution(n, info) {
  const INF = 1e9;
  const graph = Array.from(Array(n + 1), () => Array(n + 1).fill(INF));
  for (let i = 1; i < n; i++) {
    for (let j = 1; j < n; j++) {
      if (i === j) graph[i][j] = 0;
    }
  }
  info.forEach((information) => {
    const [a, b] = information;
    graph[a][b] = 1;
  });

  for (let k = 1; k < n + 1; k++) {
    for (let i = 1; i < n + 1; i++) {
      for (let j = 1; j < n + 1; j++) {
        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
      }
    }
  }

  let result = 0;
  for (let i = 1; i < n + 1; i++) {
    let count = 0;
    for (let j = 1; j < n + 1; j++) {
      if (graph[i][j] !== INF || graph[j][i] != INF) count++;
    }
    if (count === n) result++;
  }
  return result;
}

console.log(solution(n, info));
