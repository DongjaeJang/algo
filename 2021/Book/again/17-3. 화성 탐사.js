const n1 = 3;
const info1 = [
  [5, 5, 4],
  [3, 9, 1],
  [3, 2, 7],
];
const n2 = 5;
const info2 = [
  [3, 7, 2, 0, 1],
  [2, 8, 0, 9, 1],
  [1, 2, 1, 8, 1],
  [9, 8, 9, 2, 0],
  [3, 6, 5, 1, 5],
];
const n3 = 7;
const info3 = [
  [9, 0, 5, 1, 1, 5, 3],
  [4, 1, 2, 1, 6, 5, 3],
  [0, 7, 6, 1, 6, 8, 5],
  [1, 1, 7, 8, 3, 2, 3],
  [9, 4, 0, 7, 6, 4, 1],
  [5, 8, 3, 2, 4, 8, 3],
  [7, 4, 8, 4, 8, 3, 4],
];

function solution(n, info) {
  const INF = 1e9;
  const distance = Array.from(Array(n), () => Array(n).fill(INF));
  dijkstra(0, 0, distance, info);
  return distance[n - 1][n - 1];
}

function dijkstra(currentX, currentY, distance, map) {
  const queue = [];
  const mlen = map.length;
  distance[currentX][currentY] = map[currentX][currentY];
  queue.push({ cost: map[currentX][currentY], a: currentX, b: currentY });
  const dx = [-1, 1, 0, 0];
  const dy = [0, 0, -1, 1];
  while (queue.length > 0) {
    queue.sort((a, b) => a.cost - b.cost);
    const current = queue.shift();
    if (distance[current.a][current.b] < current.cost) continue;

    for (let i = 0; i < 4; i++) {
      const nextX = current.a + dx[i];
      const nextY = current.b + dy[i];
      if (nextX < 0 || nextY < 0 || nextX >= mlen || nextY >= mlen) continue;
      const cost = current.cost + map[nextX][nextY];
      if (cost < distance[nextX][nextY]) {
        distance[nextX][nextY] = cost;
        queue.push({ cost: cost, a: nextX, b: nextY });
      }
    }
  }
}

console.log(solution(n3, info3));
