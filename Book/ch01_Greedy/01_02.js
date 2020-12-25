/**
 * 주어진 수들을 M번 더해서 가장 큰 수
 * 특정 인덱스가 연속해서 K번까지만 가능
 */
const ex1 = "5 8 3";
const arr1 = "2 4 5 4 6";
const ex2 = "5 1000000000 4";
const arr2 = "2 4 5 4 6";

// case2. 반복되는 수열을 파악함. 수열이 반복되는 횟수 = M % (K + 1) 이 된다.
// => K번 가장 큰수가 나오고, 두번째로 큰 수 1개가 나오기 때문에
const solution = (ex, arr) => {
  let temp = ex.split(" ").map((v) => Number(v));
  const [N, M, K] = temp;
  let array = [...arr.split(" ").map((v) => Number(v))].sort().reverse();
  let answer = 0;

  const first = array[0];
  const second = array[1];

  // 가장 큰 수가 더해지는 횟수 count
  let count = Math.floor(M / (K + 1)) * K;
  count += M % (K + 1);

  answer += count * first;
  answer += (M - count) * second;

  return answer;
};

console.log(solution(ex2, arr2));
