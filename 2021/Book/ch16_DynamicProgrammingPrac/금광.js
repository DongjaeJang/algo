const n1 = 3;
const m1 = 4;
const map1 = [
  [1, 3, 3, 2],
  [2, 1, 4, 1],
  [0, 6, 4, 7],
];
const n2 = 4;
const m2 = 4;
const map2 = [
  [1, 3, 1, 5],
  [2, 2, 4, 1],
  [5, 0, 2, 3],
  [0, 6, 1, 2],
];

const solution = (n, m, map) => {
  const dmap = Array.from(Array(n), () => Array(m).fill(null));
  for (let i = 0; i < n; i++) dmap[i][0] = map[i][0];

  for (let col = 1; col < m; col++) {
    for (let row = 0; row < n; row++) {
      if (row === 0) {
        dmap[row][col] = Math.max(dmap[row][col - 1], dmap[row + 1][col - 1]);
      } else if (row === n - 1) {
        dmap[row][col] = Math.max(dmap[row - 1][col - 1], dmap[row][col - 1]);
      } else {
        dmap[row][col] = Math.max(
          dmap[row - 1][col - 1],
          dmap[row][col - 1],
          dmap[row + 1][col - 1]
        );
      }
      dmap[row][col] += map[row][col];
    }
  }
  let answer = -1;
  for (let i = 0; i < n; i++) {
    if (answer < dmap[i][m - 1]) answer = dmap[i][m - 1];
  }

  return answer;
};

console.log(solution(n1, m1, map1));
