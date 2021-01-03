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

console.log(solution(n3, map3));
