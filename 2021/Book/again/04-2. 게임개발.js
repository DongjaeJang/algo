/**
 * 1. 현재 방향 기준, 왼쪽부터 차례대로 갈 곳을 정한다.
 * 2. 왼쪽에 가보지 않은 칸이 있으면, 그리로 전진. 없으면 다시 회전
 * 3. 네 방향이 모두 가본 칸이거나 바다로 되어있는 경우, 방향 유지한 채 한칸 뒤로가고 1번 진행.
 * 4. 뒤가 바다라면 종료
 */
const info = [1, 1, 0];
const map = [
  [1, 1, 1, 1],
  [1, 0, 0, 1],
  [1, 1, 0, 1],
  [1, 1, 1, 1],
];

function solution(info, map) {
  let [currentX, currentY, direction] = info;
  const mlen = map.length;
  // 북 동 남 서 --- direction 기준으로
  const dx = [-1, 0, 1, 0];
  const dy = [0, 1, 0, -1];
  let count = 0;
  // 플레이어 위치 방문 처리
  let land = 1;
  map[currentX][currentY] = 2;
  while (true) {
    direction = turnLeft(direction);
    // 다음 방향
    let nextX = currentX + dx[direction];
    let nextY = currentY + dy[direction];

    // 다음 방향이 0이면 전진
    if (map[nextX][nextY] === 0) {
      count = 0;
      land++;
      map[nextX][nextY] = 2;
      currentX = nextX;
      currentY = nextY;
      continue;
    } else count += 1;

    // count가 4이면 한 바퀴 돈 것이므로 갈 수 있는 방향이 없는 것. 뒤로 후진
    if (count === 4) {
      nextX = currentX - dx[direction];
      nextY = currentY - dy[direction];
      if (map[nextX][nextY] === 1) break;
      else {
        currentX = nextX;
        currentY = nextY;
        count = 0;
      }
    }
  }
  return land;
}

function turnLeft(direction) {
  direction--;
  if (direction === -1) direction = 3;
  return direction;
}

console.log(solution(info, map));
