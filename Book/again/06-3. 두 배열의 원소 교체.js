const k = 3;
const a = [1, 2, 5, 4, 3];
const b = [5, 5, 6, 6, 5];

function solution(k, a, b) {
  // a는 오름차순 정렬, b는 내림차순 정렬
  a.sort((a, b) => a - b);
  b.sort((a, b) => b - a);

  while (k > 0) {
    if (a[0] >= b[0]) break;
    else {
      const currentA = a.shift();
      const currentB = b.shift();
      a.push(currentB);
      b.push(currentA);
      k--;
    }
  }
  return a.reduce((acc, cur) => (acc += cur), 0);
}

console.log(solution(k, a, b));
