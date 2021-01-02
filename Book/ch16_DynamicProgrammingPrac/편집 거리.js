const from1 = "cat";
const to1 = "cut";
const from2 = "sunday";
const to2 = "saturday";
const from3 = "aabbb";
const to3 = "bbbaa";

const solution = (from, to) => {
  const flen = from.length;
  const tlen = to.length;
  // dp 테이블 초기화
  const dp = Array.from(Array(tlen + 1), () => Array(flen + 1).fill(0));
  // dp 테이블 초기설정
  for (let i = 1; i < flen + 1; i++) dp[i][0] = i;
  for (let j = 1; j < tlen + 1; j++) dp[0][j] = j;
  // 최소 편집 거리 계싼
  for (let i = 1; i < flen + 1; i++) {
    for (let j = 1; j < tlen + 1; j++) {
      // 문자가 같으면 왼쪽 위 해당하는 수 대입
      if (from[i - 1] === to[j - 1]) dp[i][j] = dp[i - 1][j - 1];
      // 문자가 다르면 대입(왼), 삭제(위), 교체(왼쪽 위) 중 최소 비용 대입
      else
        dp[i][j] = 1 + Math.min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]);
    }
  }
  return dp[flen - 1][tlen - 1];
};

console.log(solution(from3, to3));
