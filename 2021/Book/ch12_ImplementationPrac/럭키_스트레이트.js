const num1 = 123402;
const num2 = 7755;
const num3 = 1111111111;

const solution = (num) => {
  const strNum = num + "";
  const mid = strNum.length / 2;
  const left = strNum.slice(0, mid);
  const right = strNum.slice(mid);
  const leftSum = left
    .split("")
    .map((v) => Number(v))
    .reduce((acc, cur) => (acc += cur), 0);
  const rightSum = right
    .split("")
    .map((v) => Number(v))
    .reduce((acc, cur) => (acc += cur), 0);
  return leftSum === rightSum ? "LUCKY" : "READY";
};

console.log(solution(num3));
