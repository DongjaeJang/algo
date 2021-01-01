const n1 = 4;
const k1 = 2;
const x1 = 1;
const info1 = [
  [1, 2],
  [1, 3],
  [2, 3],
  [2, 4],
];

const n2 = 4;
const k2 = 2;
const x2 = 1;
const info2 = [
  [1, 2],
  [1, 3],
  [1, 4],
];

const n3 = 4;
const k3 = 1;
const x3 = 1;
const info3 = [
  [1, 2],
  [1, 3],
  [2, 3],
  [2, 4],
];
/**
 * 최단거리는 BFS를 이용
 */
const solution = (n, k, x, info) => {
  const board = Array.from(Array(n), () => Array(n).fill(0));
  info.forEach((v) => {
    board[v[0] - 1][v[1] - 1] = 1;
  });
  const distance = Array.from(Array(n).fill(987654321));

  bfs(board, x, distance);
  const answer = [];
  distance.forEach((v, i) => {
    if (v === k) answer.push(i + 1);
  });
  return answer.length === 0 ? [-1] : answer;
};

const bfs = (array, start, distance) => {
  const queue = [start - 1];
  distance[start - 1] = 0;
  while (queue.length > 0) {
    const current = queue.shift();
    for (let i = 0; i < array.length; i++) {
      if (array[current][i] !== 0) {
        queue.push(i);
        distance[i] = Math.min(distance[current] + 1, distance[i]);
      }
    }
  }
};

console.log(solution(n2, k2, x2, info2));
