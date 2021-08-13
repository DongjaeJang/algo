function solution(S) {
  let sum = 0;
  let n = 1;
  let list = [];
  while (sum < S) {
    if (!list.includes(n)) list.push(n);

    sum = list.reduce((a, b) => {
      return a + b;
    });
    if (sum > S) list.pop();
    n += 1;
  }
  return list.length;
}

console.log(solution(200));
