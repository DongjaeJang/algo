/**
 * 가장 왼쪽위 좌표 (1,1)
 * 가장 오른쪽밑 좌표 (N,N)
 */
const n1 = 5;
const arr1 = ["R", "R", "R", "U", "D", "D"];

const solution = (n, arr) => {
  // 상하좌우
  const dx = [-1, 1, 0, 0];
  const dy = [0, 0, -1, 1];
  const direction = ["U", "D", "L", "R"];

  const alen = arr.length;
  let currentX = 1;
  let currentY = 1;

  for (let i = 0; i < alen; i++) {
    const target = arr[i];
    const targetIdx = direction.indexOf(target);

    const nextX = currentX + dx[targetIdx];
    const nextY = currentY + dy[targetIdx];

    if (nextX < 1 || nextY < 1 || nextX > n || nextY > n) continue;
    currentX = nextX;
    currentY = nextY;
  }
  return [currentX, currentY];
};

console.log(solution(n1, arr1));
