let number1 = 13;
let number2 = 33;
let number3 = 10000;

const solution = (number) => {
  let result = 0;
  let numberList = [];
  for (let i = 1; i <= number; i++) {
    numberList.push(String(i));
  }
  numberList.forEach((v) => {
    v.split("").forEach((val) => {
      if (val === "3" || val === "6" || val === "9") result++;
    });
  });
  return result;
};

console.log(solution(number2));
