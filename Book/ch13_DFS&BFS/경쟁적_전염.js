const n1 = 3;
const k1 = 3;
const map1 = [
  [1, 0, 2],
  [0, 0, 0],
  [3, 0, 0],
];
const sec1 = 2;
const pos1 = [3, 2];

const n2 = 3;
const k2 = 3;
const map2 = [
  [1, 0, 2],
  [0, 0, 0],
  [3, 0, 0],
];
const sec2 = 1;
const pos2 = [2, 2];

const solution = (n, k, map, sec, pos) => {
  checkVirus(k, map, sec);
  const [x, y] = pos;
  return map[x - 1][y - 1];
};

const checkVirus = (k, map, sec) => {
  let time = 0;
  while (time < sec) {
    for (let i = 1; i <= k; i++) {
      const nowPos = findVirus(i, map);
      nowPos.forEach((v) => {
        const [x, y] = v;
        // 상 -- 마지막 포지션인지 체크
        if (x > 0) {
          if (map[x - 1][y] === 0) map[x - 1][y] = i;
        }
        // 하
        if (x < map.length - 1) {
          if (map[x + 1][y] === 0) map[x + 1][y] = i;
        }
        // 좌
        if (y > 0) {
          if (map[x][y - 1] === 0) map[x][y - 1] = i;
        }
        // 우
        if (y < map.length - 1) {
          if (map[x][y + 1] === 0) map[x][y + 1] = i;
        }
      });
    }
    time++;
  }
};

const findVirus = (num, map) => {
  const result = [];
  for (let i = 0; i < map.length; i++) {
    for (let j = 0; j < map.length; j++) {
      if (map[i][j] === num) {
        result.push([i, j]);
      }
    }
  }
  return result;
};

console.log(solution(n2, k2, map2, sec2, pos2));
