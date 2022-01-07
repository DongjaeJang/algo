const n = 3;
const info = [10, 20, 40];
const info2 = [10, 20, 40, 50];

function solution(n, info) {
  let count = 0;
  while (info.length > 1) {
    info.sort((a, b) => a - b);
    const first = info.shift();
    const second = info.shift();
    count += first + second;
    info.push(first + second);
  }
  return count;
}
console.log(solution(n, info));
