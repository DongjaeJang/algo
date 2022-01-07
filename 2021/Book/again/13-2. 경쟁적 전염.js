const n = 3,
  k = 3;
const info = [
  [1, 0, 2],
  [0, 0, 0],
  [3, 0, 0],
];
const s = 2,
  x = 3,
  y = 2;

const info2 = [
  [1, 0, 2],
  [0, 0, 0],
  [3, 0, 0],
];
const s2 = 1,
  x2 = 2,
  y2 = 2;

function solution(n, k, info, s, x, y) {
  for (let i = 1; i <= s; i++) {
    for (let num = 1; num <= k; num++) {
      const virus = find_virus(info, num);
      move_virus(info, num, virus);
    }
  }
  return info[x - 1][y - 1];
}
// 해당 숫자의 바이러스가 현재 위치한 좌표를 모두 배열로 리턴
function find_virus(map, virusNum) {
  const mlen = map.length;
  const result = [];
  for (let row = 0; row < mlen; row++) {
    for (let col = 0; col < mlen; col++) {
      if (map[row][col] === virusNum) {
        result.push([row, col]);
      }
    }
  }
  return result;
}
// find_virus를 통해 얻은 result로 무브 진행
function move_virus(map, virusNum, result) {
  const mlen = map.length;
  const dx = [-1, 1, 0, 0];
  const dy = [0, 0, -1, 1];
  for (let i = 0; i < result.length; i++) {
    const [currentX, currentY] = result[i];
    for (let j = 0; j < 4; j++) {
      const nextX = currentX + dx[j];
      const nextY = currentY + dy[j];
      if (nextX < 0 || nextY < 0 || nextX >= mlen || nextY >= mlen) continue;
      if (map[nextX][nextY] === 0) map[nextX][nextY] = virusNum;
    }
  }
}

console.log(solution(n, k, info2, s2, x2, y2));
