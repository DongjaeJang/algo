const n1 = 5;
const m1 = 6;
const map1 = [
  [1, 0, 1, 0, 1, 0],
  [1, 1, 1, 1, 1, 1],
  [0, 0, 0, 0, 0, 1],
  [1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1],
];

const bfs = (x, y, n, m, map) => {
  const dx = [-1, 1, 0, 0];
  const dy = [0, 0, -1, 1];
  const queue = [];
  queue.push([x, y]);
  // 큐가 비워질때까지 반복
  // ---> 파이썬처럼 while문 조건으로 queue를 그대로 넣으면 오류가 뜬다. 조건을 true로 하고, 탈출조건문을 내부에 적어주는 것이 좋다.
  while (true) {
    const current = queue.shift();
    const [currentX, currentY] = current;

    // 현재 위치에서 네 방향 확인
    for (let i = 0; i < 4; i++) {
      const nextX = currentX + dx[i];
      const nextY = currentY + dy[i];
      // 허용 범위 넘는 곳 무시
      if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;

      // 괴물이 있는 곳 무시
      if (map[nextX][nextY] === 0) continue;

      if (map[nextX][nextY] === 1) {
        map[nextX][nextY] = map[currentX][currentY] + 1;
        queue.push([nextX, nextY]);
      }
    }
    // queue가 더 들어갈 것이 없다면 탈출
    if (queue.length === 0) break;
  }
  return map[n - 1][m - 1];
};

const solution = (n, m, map_) => {
  let map = map_.slice();

  return bfs(0, 0, n, m, map);
};

console.log(solution(n1, m1, map1));
