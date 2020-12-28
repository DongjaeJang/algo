const ex1 = [25, 5];
const ex2 = [17, 4];

// case1. N이 K의 배수가 될때까지 -1, 배수가 되면 K로 나누기 --- 한단계씩 거치므로 시간이 더 오래걸림
const solution = (ex) => {
  let [N, K] = ex;
  let count = 0;
  while (N !== 1) {
    if (N % K === 0) {
      N /= K;
      count++;
    } else {
      N -= 1;
      count++;
    }
  }
  return count;
};

console.log(solution(ex2));
