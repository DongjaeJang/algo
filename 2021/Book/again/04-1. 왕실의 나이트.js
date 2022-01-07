/**
 * 이동 8가지
 * dx = [-2,-2,-1,-1,1,1,2,2]
 * dy = [-1,1,-2,2,-2,2,-1,1]
 * 현 위치에서 범위를 넘으면 count 하지 않는다.
 */

const info = "a1";
const info2 = "g5";
function solution(info) {
  const [currentX, currentY] = info.split("");
  const x = "abcdefgh";
  const y = "12345678";
  const dx = [-2, -2, -1, -1, 1, 1, 2, 2];
  const dy = [-1, 1, -2, 2, -2, 2, -1, 1];
  let count = 0;
  // 움직일 수 있는 경우의 수가 8가지이므로 모두 확인해본다.
  for (let i = 0; i < 8; i++) {
    const nextX = x.indexOf(currentX) + dx[i];
    const nextY = y.indexOf(currentY) + dy[i];

    if (nextX < 0 || nextX > 7 || nextY < 0 || nextY > 7) continue;
    count++;
  }
  return count;
}

console.log(solution(info2));
