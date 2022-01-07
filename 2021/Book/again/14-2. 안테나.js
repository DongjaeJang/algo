const n = 4;
const info = [5, 1, 7, 9];
const n2 = 5;
const info2 = [1, 7, 5, 11, 13];

function solution(n, info) {
  const mid = Math.floor(info.length / 2);

  return n % 2 === 0
    ? info.sort((a, b) => a - b)[mid - 1]
    : info.sort((a, b) => a - b)[mid];
}

console.log(solution(n2, info2));
