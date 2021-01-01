const num1 = [5, 6];
const op1 = [0, 0, 1, 0];
const num2 = [3, 4, 5];
const op2 = [1, 0, 1, 0];
const num3 = [1, 2, 3, 4, 5, 6];
const op3 = [2, 1, 1, 1];

const solution = (num, op) => {
  const op_ = [];
  op.forEach((v, i) => {
    if (i === 0) for (let k = 0; k < v; k++) op_.push("+");
    else if (i === 1) for (let k = 0; k < v; k++) op_.push("-");
    else if (i === 2) for (let k = 0; k < v; k++) op_.push("*");
    else if (i === 3) for (let k = 0; k < v; k++) op_.push("/");
  });
  const operationSet = [];
  permutation("", operationSet, op_);
  const answerList = [];
  for (let i = 0; i < operationSet.length; i++) {
    allOperation(num, operationSet[i], answerList);
  }
  answerList.sort((a, b) => a - b);
  return [answerList[answerList.length - 1], answerList[0]];
};

const permutation = (temp, operationSet, op) => {
  if (op.length === 0) {
    if (!operationSet.includes(temp)) operationSet.push(temp);
  }

  const clone = op.slice();
  for (let i in op) {
    let cur = clone.shift();
    permutation(temp + cur, operationSet, clone);
    clone.push(cur);
  }
};

const allOperation = (num, operation, answerList) => {
  const numberList = num.slice();
  const order = operation.split("");
  let su = numberList.shift();
  while (numberList.length > 0) {
    const currentOp = order.shift();
    const currentNum = numberList.shift();
    if (currentOp === "+") su += currentNum;
    else if (currentOp === "-") su -= currentNum;
    else if (currentOp === "*") su *= currentNum;
    else if (currentOp === "/") {
      if (su < 0) {
        su *= -1;
        su = Math.floor(su / currentNum);
        su *= -1;
      } else {
        su = Math.floor(su / currentNum);
      }
    }
  }
  answerList.push(su);
};

console.log(solution(num2, op2));
