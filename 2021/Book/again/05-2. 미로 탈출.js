const n = 5;
const m = 6;
const map = [
  [1, 0, 1, 0, 1, 0],
  [1, 1, 1, 1, 1, 1],
  [0, 0, 0, 0, 0, 1],
  [1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1],
];

function solution(n, m, map) {
  let currentX = 0,
    currentY = 0;
  bfs(currentX, currentY, map);
  return map[n - 1][m - 1];
}

function bfs(x, y, map) {
  const dx = [-1, 1, 0, 0];
  const dy = [0, 0, -1, 1];
  const xlen = map.length;
  const ylen = map[0].length;
  const queue = [];
  queue.push([x, y]);
  while (queue.length > 0) {
    const [currentX, currentY] = queue.shift();
    for (let i = 0; i < 4; i++) {
      const nextX = currentX + dx[i];
      const nextY = currentY + dy[i];
      if (nextX < 0 || nextY < 0 || nextX === xlen || nextY === ylen) continue;
      if (map[nextX][nextY] === 1) {
        map[nextX][nextY] = map[currentX][currentY] + 1;
        queue.push([nextX, nextY]);
      }
    }
  }
}

console.log(solution(n, m, map));
