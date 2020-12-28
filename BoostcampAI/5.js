// const solution = (n) => {
//   if (n === 1) return 0;

//   let answer = 0;
//   const binaryTarget = n.toString(2);
//   const targetCount = countOne(binaryTarget);

//   for (let i = 1; i < n; i++) {
//     const binaryTemp = i.toString(2);
//     const tempCount = countOne(binaryTemp);
//     if (tempCount === targetCount) answer++;
//   }

//   return answer;
// };

// const countOne = (n) => {
//   return n.split("").filter((v) => v === "1").length;
// };

// 비트 수 계산해서 재귀함수
const solution = (n) => {
  if (n === 1) return 0;
  let answer = [];
  const binaryTarget = n.toString(2);
  findAnswer(binaryTarget, answer);
  return answer.reduce((acc, cur) => {
    return (acc += cur);
  }, 0);
};

const findAnswer = (binaryTarget, answer) => {
  const targetCount = countOne(binaryTarget);
  let bunja = 1;
  let bunmo = 1;
  // 자릿수가 작은 것 총합
  let btlen = binaryTarget.length - 1;
  for (let i = 0; i < targetCount; i++) {
    bunja *= btlen;
    btlen--;
  }
  for (let i = 1; i <= targetCount; i++) bunmo *= i;
  let idx = -1;
  for (let i = 1; i < binaryTarget.length; i++) {
    if (binaryTarget[i] === "1") {
      idx = i;
      break;
    }
  }
  answer.push(bunja / bunmo);

  if (idx === -1) return;
  const nextBinaryTarget = binaryTarget.slice(idx);
  if (nextBinaryTarget.length === 1) return;
  findAnswer(nextBinaryTarget, answer);
};

const countOne = (n) => {
  return n.split("").filter((v) => v === "1").length;
};

console.log(solution(2 ** 30));
