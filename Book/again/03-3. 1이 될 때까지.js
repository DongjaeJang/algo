/**
 * 연산 2가지
 * 1. N -= 1
 * 2. N /= K
 */
const info = [25, 5];
const info2 = [37, 5];

function solution(info) {
  let N = info[0];
  const K = info[1];
  let count = 0;
  while (N > 1) {
    // K로 나누어 떨어지는 수 target을 찾는다.(N보다 작음)
    const target = Math.floor(N / K) * K;
    count += N - target;
    N = target;
    // K로 나누기
    if (N % K === 0) {
      N /= K;
      count++;
    }
  }
  return count;
}

console.log(solution(info2));
