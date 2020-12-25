const ex1 = [25, 5];
const ex2 = [17, 4];

// case2. N이 K의 배수가 될때까지 -1, 배수가 되면 K로 나누기 --- case1 보다 빠르다.
const solution = (ex) => {
  let [N, K] = ex;
  let count = 0;
  while (true) {
    // N이 K로 나누어떨어질 때까지 1씩 배줌
    let target = Math.floor(N / K) * K;
    count += N - target;
    N = target;

    // N이 K보다 작아지면 더 나눌 수 없으므로 break
    if (N < K) break;

    // K로 나누기
    count += 1;
    N /= K;
  }

  count += N - 1;

  return count;
};

console.log(solution(ex2));
