const n1 = 7;
const T1 = [3, 5, 1, 1, 2, 4, 2];
const P1 = [10, 20, 10, 20, 15, 40, 200];
const n2 = 10;
const T2 = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1];
const P2 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

function solution(n, t, p) {
  const dp = Array(n + 1).fill(0);
  const result = [];

  for (let i = n - 1; i >= 0; i--) {
    const cur = t[i];
    const time = i + t[i];
    if (time > n) continue;
    else dp[i] = Math.max(dp[i], dp[time] + p[i]);
  }
  return Math.max.apply(null, dp);
}

console.log(solution(n1, T1, P1));
