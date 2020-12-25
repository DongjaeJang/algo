/**
 * 주어진 수들을 M번 더해서 가장 큰 수
 * 특정 인덱스가 연속해서 K번까지만 가능
 */
const ex1 = "5 8 3";
const arr1 = "2 4 5 4 6";
const ex2 = "5 1000000000 4";
const arr2 = "2 4 5 4 6";

// case1. 큰 수라면 시간 초과날 수 있음
const solution = (ex, arr) => {
  let temp = ex.split(" ").map((v) => Number(v));
  const N = temp[0];
  const M = temp[1];
  const K = temp[2];
  let array = [...arr.split(" ").map((v) => Number(v))].sort().reverse();
  let answer = 0;

  for (let i = 0; i < M; i++) {
    if (i === 0) {
      answer += array[0];
    } else {
      if (i % K === 0) answer += array[1];
      else answer += array[0];
    }
  }
  return answer;
};

console.log(solution(ex2, arr2));
