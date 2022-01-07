const arr1 = [15, 11, 4, 8, 5, 2, 4];
const arr2 = [13, 12, 15, 7, 6, 5, 4, 3, 2, 8];
/**
 * 가장 긴 증가하는 수열 찾기
 * ==> D[i] === array[i]를 마지막 원소로 가지는 부분 수열의 최대 길이
 * 1. dp 테이블을 모두 1로 초기화
 * 2. 모든 0 <= j < i에 대해,
 *      if (array[j] < array[i])
 *          dp[i] = Math.max(dp[i], dp[j] + 1)
 */
const solution = (arr) => {
  arr.reverse();
  const dp = Array(arr.length).fill(1);
  for (let i = 1; i < arr.length; i++) {
    for (let j = 0; j < i; j++)
      if (arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
  }
  return arr.length - Math.max.apply(null, dp);
};

console.log(solution(arr1));
