let cryptogram_1 = "browoanoommnaon";
let cryptogram_2 = "zyelleyz";

const solution = (cryptogram) => {
  let str = cryptogram.split("");
  let stack = [];

  str.forEach((v) => {
    if (stack.length === 0) {
      stack.push(v);
    } else {
      if (stack[stack.length - 1] === v) {
        stack.pop();
      } else stack.push(v);
    }
  });

  return stack.length === 0 ? '""' : stack.join("");
};

console.log(solution(cryptogram_2));
