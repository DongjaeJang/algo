const n1 = 3;
const m1 = 4;
const info1 = [
  [1, 3, 3, 2],
  [2, 1, 4, 1],
  [0, 6, 4, 7],
];
const n2 = 4;
const m2 = 4;
const info2 = [
  [1, 3, 1, 5],
  [2, 2, 4, 1],
  [5, 0, 2, 3],
  [0, 6, 1, 2],
];

function solution(n, m, info) {
  const INF = 1e9;
  // 다이나믹 맵 설정
  const dmap = Array.from(Array(n), () => Array(n).fill(0));
  // 초깃값은 첫 줄 그대로
  for (let i = 0; i < n; i++) {
    dmap[i][0] = info[i][0];
  }
  // 다이나믹 시작
  for (let j = 1; j < m; j++) {
    for (let i = 0; i < n; i++) {
      // 첫째 줄이면 해당 행과 아래 행만 체크
      if (i === 0) {
        dmap[i][j] = Math.max(dmap[i][j - 1], dmap[i + 1][j - 1]) + info[i][j];
      } else if (i === n - 1) {
        dmap[i][j] = Math.max(dmap[i - 1][j - 1], dmap[i][j - 1]) + info[i][j];
      } else {
        dmap[i][j] =
          Math.max(dmap[i - 1][j - 1], dmap[i][j - 1], dmap[i + 1][j - 1]) +
          info[i][j];
      }
    }
  }
  let result = -1;
  for (let i = 0; i < n; i++) {
    if (result < dmap[i][m - 1]) result = dmap[i][m - 1];
  }
  return result;
}

console.log(solution(n2, m2, info2));
