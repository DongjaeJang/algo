/**
 * 맵 크기 : N x N
 * 물고기 : M마리
 * 초기 상어 사이즈 : 2
 *
 * [ 상 하 좌 우 ]
 * 아기 상어 움직임 조건 :
 * 1. 자신보다 큰 물고기는 못 지나간다.
 * 2. 자신보다 작거나 같은 물고기를 지나갈 수 있다.
 * 3. 자신보다 작은 물고기를 먹을 수 있다.
 */
const n1 = 3;
const map1 = [
  [0, 0, 0],
  [0, 0, 0],
  [0, 9, 0],
];
const n2 = 3;
const map2 = [
  [0, 0, 1],
  [0, 0, 0],
  [0, 9, 0],
];
const n3 = 4;
const map3 = [
  [4, 3, 2, 1],
  [0, 0, 0, 0],
  [0, 0, 9, 0],
  [1, 2, 3, 4],
];

const findTarget = (map, size, currentX, currentY) => {
  const result = [];
  let min = 987654321;
  for (let row = 0; row < map.length; row++) {
    for (let col = 0; col < map.length; col++) {
      if (
        map[row][col] < size &&
        map[row][col] > 0 &&
        Math.abs(currentX - row) + Math.abs(currentY - col) <= min
      ) {
        min = Math.abs(currentX - row) + Math.abs(currentY - col);
        result.push({ x: row, y: col, cost: min });
      }
    }
  }
  if (result.length === 0) return 0;
  const final = result.filter((v) => v.cost === min);
  final.sort((a, b) => {
    if (a.x === b.x) return a.y - b.y;
    return a.x - b.x;
  });
  return final;
};

const findShark = (map) => {
  for (let row = 0; row < map.length; row++) {
    for (let col = 0; col < map.length; col++) {
      if (map[row][col] === 9) return [row, col];
    }
  }
};

const solution = (n, map) => {
  let second = 0;
  let sharkSize = 2;
  let count = 0;
  let [currentX, currentY] = findShark(map);
  if (!findTarget(map, sharkSize, currentX, currentY)) return second;

  while (true) {
    if (count === sharkSize) {
      count -= sharkSize;
      sharkSize++;
    }
    const currentTarget = findTarget(map, sharkSize, currentX, currentY);
    if (!currentTarget) return second;
    second += currentTarget[0].cost;
    map[currentX][currentY] = 0;
    currentX = currentTarget[0].x;
    currentY = currentTarget[0].y;
    map[currentX][currentY] = 9;
    count += 1;
  }
};

// console.log(solution(n3, map3));

// 책 풀이
// 자신보다 큰 물고기는 지나갈 수 없기때문에 최단 거리를 구할 대 bfs를 사용하는 게 좋음.
// 매 먹이를 찾을 때마다 bfs사용해서 최단거리만을 구한 뒤 진행한다.

const solution2 = (n, map) => {
  const INF = 987654321;
  let now_size = 2;
  let now_x = 0,
    now_y = 0;
  let second = 0;
  let count = 0;
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (map[i][j] === 9) {
        now_x = i;
        now_y = j;
        map[now_x][now_y] = 0;
      }
    }
  }

  const dx = [-1, 0, 1, 0];
  const dy = [0, 1, 0, -1];

  const bfs = () => {
    const distance = Array.from(Array(n), () => Array(n).fill(-1));
    const queue = [];
    queue.push([now_x, now_y]);
    distance[now_x][now_y] = 0;

    while (queue.length > 0) {
      const [x, y] = queue.shift();
      for (let i = 0; i < 4; i++) {
        const nextX = x + dx[i];
        const nextY = y + dy[i];
        if (0 <= nextX && nextX < n && 0 <= nextY && nextY < n) {
          if (distance[nextX][nextY] == -1 && map[nextX][nextY] <= now_size) {
            distance[nextX][nextY] = distance[x][y] + 1;
            queue.push([nextX, nextY]);
          }
        }
      }
    }
    return distance;
  };

  const find = (distance) => {
    let x = 0,
      y = 0;
    let min = INF;
    for (let i = 0; i < n; i++) {
      for (let j = 0; j < n; j++) {
        if (distance[i][j] !== -1 && 1 <= map[i][j] && map[i][j] < now_size) {
          if (distance[i][j] < min) {
            x = i;
            y = j;
            min = distance[i][j];
          }
        }
      }
    }
    if (min === INF) return false;
    else return [x, y, min];
  };

  while (true) {
    const value = find(bfs());
    if (!value) return second;
    else {
      now_x = value[0];
      now_y = value[1];
      second += value[2];
      map[now_x][now_y] = 0;
      count += 1;
      if (count >= now_size) {
        count -= now_size;
        now_size += 1;
      }
    }
  }
};

console.log(solution2(n3, map3));
