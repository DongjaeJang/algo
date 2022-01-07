/**
 * 맵 : N x M 직사각형
 * (A, B) => A는 북쪽으로부터 떨어진 칸의 갯수(행), B는 서쪽으로부터 떨어진 칸의 갯수(열)
 *
 * < 움직임 >
 * 1. 현재 방향에서 반시계 방향부터 갈 곳을 정함
 * 2. 가보지 않은 땅이라면 그 방향으로 전진, 가본 땅이라면 1번 진행
 * 3. 네 방향이 모두 가본 칸이거나 바다라면, 방향을 유지한채로 한칸 뒤로 간다.
 *    -- 만약 뒤가 바다라면 움직임을 멈춘다.
 */

// 내 풀이
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

  // 북 서 남 동 (반시계)
  const pd = [0, 3, 2, 1];
  const dx = [-1, 0, 1, 0];
  const dy = [0, -1, 0, 1];

  // 시작 위치 방문 처리
  newMap[playerX][playerY] = 2;

  // 방향 idx 지정
  let idx = pd.indexOf(playerDirection);

  while (true) {
    // 전방향이 모두 못가는 곳이라면 방향을 유지한 채로 뒤로 간다. 만약 바다라면 반복문 탈출
    if (
      newMap[playerX - 1][playerY] !== 0 &&
      newMap[playerX + 1][playerY] !== 0 &&
      newMap[playerX][playerY - 1] !== 0 &&
      newMap[playerX][playerY + 1] !== 0
    ) {
      // 방향을 유지한 채 뒤로 한칸
      let nextX = playerX - dx[idx % 4];
      let nextY = playerY - dy[idx % 4];

      // 뒤가 바다인 경우 반복문 탈출
      if (newMap[nextX][nextY] === 1) {
        break;
      } else {
        playerX = nextX;
        plyaerY = nextY;
      }
    }

    // 다음 방향찾기 위해 idx 증가 --- idx가 계속 커질 수 있으므로 배열에서 idx를 부를 때는 % 4를 해준다.
    // nextX, nextY는 다음으로 움직일 방향이 된다.
    idx++;
    let nextX = playerX + dx[idx % 4];
    let nextY = playerY + dy[idx % 4];

    // 다음 진행할 칸이 0일 때 --- 이동하고, 방문처리를 해준다.
    if (newMap[nextX][nextY] === 0) {
      playerX = nextX;
      playerY = nextY;
      newMap[nextX][nextY] = 2;
    }
  }
  return newMap
    .join("")
    .split("")
    .filter((v) => v === "2").length;
};

console.log(solution(size1, player1, map1));
