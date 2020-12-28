/**
 * 연산 4가지
 * 1. X % 5 === 0 ? X /= 5;
 * 2. X % 3 === 0 ? X /= 3;
 * 3. X % 2 === 0 ? X /= 2;
 * 4. X -= 1;
 */
const initialArray = (array) => {
  for (let i = 0; i <= 30000; i++) array.push(0);
};
// 점화식 => a(i) = min( a(i-1), a(i/2), a(i/3), a(i/5) ) + 1
const dp = (array, n) => {
  for (let i = 2; i <= n; i++) {
    // 1을 빼는 경우
    array[i] = array[i - 1] + 1;
    // 2로 나눠지는 경우
    if (i % 2 === 0)
      array[i] = Math.min(array[i], array[Math.floor(i / 2)] + 1);
    // 3으로 나눠지는 경우
    if (i % 3 === 0)
      array[i] = Math.min(array[i], array[Math.floor(i / 3)] + 1);
    // 5로 나눠지는 경우
    if (i % 5 === 0)
      array[i] = Math.min(array[i], array[Math.floor(i / 5)] + 1);
  }

  return array[n];
};

const array = [];
initialArray(array);
console.log(dp(array, 26));
