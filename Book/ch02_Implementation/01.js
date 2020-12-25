/**
 * 체스판 8x8
 * 특정위치에서 움직일 수 있는 경우의 수 출력
 * 움직일 수 있는 방법
 * 1. 수평 2 + 수직 1
 * 2. 수직 2 + 수평 1
 *
 * 표시 *
 * 행 = 1~8
 * 열 = a~h
 */
const ex1 = "a1";
const ex2 = "c2";
const ex3 = "h1";
const ex4 = "b1";

const solution = (pos) => {
  const posX = "12345678";
  const posY = "abcdefgh";
  const currentX = posX.indexOf(pos[1]);
  const currentY = posY.indexOf(pos[0]);

  // 상(좌, 우) 하(좌, 우) 좌(상, 하) 우(상, 하)
  const dx = [-2, -2, 2, 2, -1, 1, -1, 1];
  const dy = [-1, 1, -1, 1, -2, -2, 2, 2];

  let answer = 0;

  for (let idx = 0; idx < dx.length; idx++) {
    const nextX = currentX + dx[idx];
    const nextY = currentY + dy[idx];

    if (nextX > -1 && nextX < 8 && nextY > -1 && nextY < 8) answer++;
  }
  return answer;
};

console.log(solution(ex4));
