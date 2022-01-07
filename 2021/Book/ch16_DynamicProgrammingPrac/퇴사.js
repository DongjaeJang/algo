const n1 = 7;
const T1 = [3, 5, 1, 1, 2, 4, 2];
const P1 = [10, 20, 10, 20, 15, 40, 200];
const n2 = 10;
const T2 = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1];
const P2 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
/**
 * 마지막 날부터 거꾸로 거슬러 올라옴
 * 점화식 == dp[i] = Math.max(p[i] + dp[t[i] + i], max_value)
 */

const solution = (n, T, P) => {
  const dP = Array(n + 1).fill(0);
  let result = 0;
  for (let i = n - 1; i >= 0; i--) {
    const curT = T[i];
    const time = i + curT;
    if (time <= n) {
      dP[i] = Math.max(P[i] + dP[time], result);
      result = dP[i];
    } else {
      dP[i] = result;
    }
  }
  return result;
};

console.log(solution(n1, T1, P1));
