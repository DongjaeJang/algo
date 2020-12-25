// 책 풀이
const size1 = [4, 4];
const player1 = [1, 1, 0];
const map1 = [
  [1, 1, 1, 1],
  [1, 0, 0, 1],
  [1, 1, 0, 1],
  [1, 1, 1, 1],
];

const solution = (size, player, map) => {
  const [mapWidth, mapHeight] = size;
  let [playerX, playerY, playerDirection] = player;
  let newMap = map.slice();

  // 북 동 남 서
  const dx = [-1, 0, 1, 0];
  const dy = [0, 1, 0, -1];

  // 아예 거꾸로 idx를 옮긴다. 좌측 방향 전환 함수
  const turn_left = () => {
    playerDirection -= 1;
    if (playerDirection === -1) playerDirection = 3;
  };

  // 시작 위치 방문 처리
  newMap[playerX][playerY] = 2;

  let count = 1;
  let turn = 0;

  while (true) {
    // 방향 전환
    turn_left();
    // 다음 방향
    let nextX = playerX + dx[playerDirection];
    let nextY = playerY + dy[playerDirection];

    // 다음 방향이 아직 안가본 곳이라면
    if (newMap[nextX][nextY] === 0) {
      newMap[nextX][nextY] = 2;
      playerX = nextX;
      playerY = nextY;
      count += 1;
      turn = 0;
      continue;
    }
    // 가본 곳이라면 turn 횟수 증가
    else turn += 1;

    // 다 방문했던 곳이라면
    if (turn === 4) {
      nextX = playerX - dx[playerDirection];
      nextY = playerY - dy[playerDirection];

      // 뒤가 바다면 반복문 탈출
      if (newMap[nextX][nextY] === 1) {
        break;
      } else {
        playerX = nextX;
        playerY = nextY;
        turn = 0;
      }
    }
  }
  return count;
};

console.log(solution(size1, player1, map1));
