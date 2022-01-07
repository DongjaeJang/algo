const n = 5;
const m = 3;
const balls = [1, 3, 2, 3, 2];
const m2 = 5;
const balls2 = [1, 5, 4, 3, 2, 4, 5, 2];
const m3 = 4;
const balls3 = [4, 4, 4, 4];

function solution(n, m, balls) {
  balls.sort((a, b) => a - b);
  let count = 0;
  for (let weight = 1; weight < m; weight++) {
    const su = balls.filter((v) => v === weight).length;
    if (su === 0) continue;
    const upper = balls.filter((v) => v > weight).length;
    count += su * upper;
  }
  return count;
}
console.log(solution(n, m3, balls3));
