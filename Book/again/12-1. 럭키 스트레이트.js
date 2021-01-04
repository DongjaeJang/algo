const num1 = 123402;
const num2 = 7755;

function solution(num) {
  const numberList = String(num)
    .split("")
    .map((v) => Number(v));
  const mid = numberList.length / 2;
  const left = numberList.slice(0, mid);
  const right = numberList.slice(mid);

  let sum = 0;
  left.forEach((v) => (sum += v));
  right.forEach((v) => (sum -= v));

  return sum === 0 ? "LUCKY" : "READY";
}

console.log(solution(num2));
