/**
 * 0은 아이스크림, 1은 칸막이
 * dfs를 통해 상하좌우를 계속해서 체크한다.
 */

const iceMap = [
  [0, 0, 1, 1, 0],
  [0, 0, 0, 1, 1],
  [1, 1, 1, 1, 1],
  [0, 0, 0, 0, 0],
];
const iceMap2 = [
  [0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0],
];

function dfs(map, x, y) {
  // 종료 조건 앞에 설정 -- map 범위를 넘은 경우
  const xlen = map.length;
  const ylen = map[0].length;
  if (x < 0 || y < 0 || x === xlen || y === ylen) return;
  if (map[x][y] === 1) return;
  else {
    map[x][y] = 1;
    // 상하좌우 체크
    dfs(map, x - 1, y);
    dfs(map, x + 1, y);
    dfs(map, x, y - 1);
    dfs(map, x, y + 1);
  }

  return true;
}

function solution(map) {
  let count = 0;
  const xlen = map.length;
  const ylen = map[0].length;
  for (let i = 0; i < xlen; i++) {
    for (let j = 0; j < ylen; j++) {
      if (dfs(map, i, j)) count += 1;
    }
  }

  return count;
}

console.log(solution(iceMap2));
