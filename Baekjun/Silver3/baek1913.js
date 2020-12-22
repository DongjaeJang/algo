function solution(n, target) {
  let box = [];

  for (let i = 0; i < n; i++) {
    box[i] = [];
    for (let j = 0; j < n; j++) {
      box[i][j] = 0;
    }
  }

  let count = n ** 2;
  let x = 0;
  let y = 0;
  let moveX = [1, 0, -1, 0];
  let moveY = [0, 1, 0, -1];
  let d = 0;

  while (count > 0) {
    box[x][y] = count--;
    let tempX = x + moveX[d];
    let tempY = y + moveY[d];
    if (
      tempX > n - 1 ||
      tempX === -1 ||
      tempY > n - 1 ||
      tempY === -1 ||
      box[tempX][tempY] !== 0
    ) {
      d += 1;
      if (d > 3) d = 0;
    }
    x += moveX[d];
    y += moveY[d];
  }

  let position = [];
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (box[i][j] === target) {
        position.push(i + 1);
        position.push(j + 1);
        break;
      }
    }
  }

  let answer = "";
  box.forEach((v) => {
    v.forEach((value, index) => {
      answer += String(value);
      if (index !== n - 1) answer += " ";
    });
    answer += "\n";
  });
  answer += String(position[0]) + " " + String(position[1]);

  return answer;
}

console.log(solution(7, 35));