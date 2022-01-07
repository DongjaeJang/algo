const n1 = 10;
const n2 = 4;

const solution = (n) => {
  const numlist = Array(n);
  numlist[0] = 1;
  let idx2 = 0,
    idx3 = 0,
    idx5 = 0;
  let next2 = 2,
    next3 = 3,
    next5 = 5;

  for (let i = 1; i < n; i++) {
    numlist[i] = Math.min(next2, next3, next5);
    if (numlist[i] === next2) {
      idx2 += 1;
      next2 = numlist[idx2] * 2;
    }
    if (numlist[i] === next3) {
      idx3 += 1;
      next3 = numlist[idx3] * 3;
    }
    if (numlist[i] === next5) {
      idx5 += 1;
      next5 = numlist[idx5] * 5;
    }
  }
  console.log(numlist);
  return numlist[n - 1];
};

console.log(solution(10));
