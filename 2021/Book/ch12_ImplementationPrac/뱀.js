const n1 = 6;
const apples1 = [
  [3, 4],
  [2, 5],
  [5, 3],
];
const direction1 = [
  [3, "D"],
  [15, "L"],
  [17, "D"],
];
const n2 = 10;
const apples2 = [
  [1, 2],
  [1, 3],
  [1, 4],
  [1, 5],
];
const direction2 = [
  [8, "D"],
  [10, "D"],
  [11, "D"],
  [13, "L"],
];
const n3 = 10;
const apples3 = [
  [1, 5],
  [1, 3],
  [1, 2],
  [1, 6],
  [1, 7],
];
const direction3 = [
  [8, "D"],
  [10, "D"],
  [11, "D"],
  [13, "L"],
];
/**
 * 종료 조건
 * 1. 벽에 부딪히거나
 * 2. 자기 몸에 부딪힐 경우
 *
 * 매초 이동 조건
 * 1. 맨 처음 방향은 우측
 * 2. 머리를 다음 칸으로 이동
 * 3. 사과가 있다면 꼬리는 유지
 *          없다면 꼬리도 함께 이동
 *
 * 아무것도 없는 길 0, 사과는 1, 몸통이 지나가고 있는 길을 2
 */
const solution = (N, apples, direction) => {
  const board = Array.from(Array(N), () => Array(N).fill(0));
  apples.forEach((v) => {
    let x = v[0] - 1;
    let y = v[1] - 1;
    board[x][y] = 1;
  });
  // 우 하 좌 상
  // 'D'를 만나면 idx++, 'L'을 만나면 idx--;
  const dx = [0, 1, 0, -1];
  const dy = [1, 0, -1, 0];

  let currentX = 0,
    currentY = 0;
  let second = 0;
  let idx = 0;
  const body = [];
  board[currentX][currentY] = 2;
  body.push([currentX, currentY]);
  while (true) {
    if (direction.length > 0) {
      if (direction[0][0] === second) {
        if (direction[0][1] === "D") {
          idx += 1;
          if (idx === 4) idx -= 4;
        } else {
          idx -= 1;
          if (idx === -1) idx += 4;
        }
        direction.shift();
      }
    }
    second++;
    let nextX = currentX + dx[idx];
    let nextY = currentY + dy[idx];

    // 벽에 부딪혔을 때 종료조건
    if (nextX > N - 1 || nextY > N - 1 || nextX < 0 || nextY < 0) break;
    // 몸에 부딪혔을 때 종료조건
    if (board[nextX][nextY] === 2) break;
    // 사과 먹었을 때, board에 체크하고 몸 길이를 늘인다
    else if (board[nextX][nextY] === 1) {
      body.push([nextX, nextY]);
      board[nextX][nextY] = 2;
    } else {
      let temp = body.shift();
      board[temp[0]][temp[1]] = 0;
      board[nextX][nextY] = 2;
      body.push([nextX, nextY]);
    }
    currentX = nextX;
    currentY = nextY;
  }
  return second;
};

console.log(solution(n3, apples3, direction3));
