/**
 * 연산 4가지
 * 1. X % 5 === 0 ? X /= 5
 * 2. X % 3 === 0 ? X /= 3
 * 3. X % 2 === 0 ? X /= 2
 * 4. X -= 1
 */
const n = 26;

function solution(n) {
  const INF = 987654321;
  const array = Array(n + 1).fill(INF);
  array[1] = 0;

  for (let i = 2; i <= n; i++) {
    if (i % 2 === 0) array[i] = Math.min(array[i], array[i / 2] + 1);
    if (i % 3 === 0) array[i] = Math.min(array[i], array[i / 3] + 1);
    if (i % 5 === 0) array[i] = Math.min(array[i], array[i / 5] + 1);
    array[i] = Math.min(array[i], array[i - 1] + 1);
  }

  console.log(array);
  return array[n];
}

console.log(solution(n));
