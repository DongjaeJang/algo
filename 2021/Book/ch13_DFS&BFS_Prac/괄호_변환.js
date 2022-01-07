/**
 * 균형잡힌 문자열 ==> ( , ) 갯수가 같은 경우
 * 올바른 문자열 ==> 균형잡힌 문자열 + 괄호의 짝이 맞는 경우
 */

const ex1 = "(()())()";
const ex2 = ")(";
const ex3 = "()))((()";

const solution = (p) => {
  return fixParen(p.slice());
};
// 균형 잡힌 괄호 문자열 판단
const isBalanced = (string) => {
  let count = 0;
  for (let i = 0; i < string.length; i++) {
    if (string[i] === "(") count++;
    else if (string[i] === ")") count--;
    if (count === 0)
      return [string.substring(0, i + 1), string.substring(i + 1)];
  }
};

// 올바른 괄호 문자열 판단
const isRight = (u) => {
  let stack = [];
  for (let i = 0; i < u.length; i++) {
    if (u[i] === "(") stack.push(u[i]);
    else if (u[i] === ")") {
      if (stack[stack.length - 1] === "(") stack.pop();
      else if (stack[stack.length - 1] === ")") stack.push();
    }
  }
  return stack.length === 0 ? true : false;
};

// 괄호 고치기
const fixParen = (string) => {
  let u = "",
    v = "";
  // 빈 문자열이면 그냥 반환
  if (string.length === 0) return "";
  // 균형잡힌 문자열 u, v 나누기
  [u, v] = isBalanced(string);
  // u가 올바른 문자열인지 판단
  let right = isRight(u);

  // 올바른 문자열 o
  if (right) return u + fixParen(v);
  // 올바른 문자열 x
  else {
    let temp = u
      .split("")
      .splice(1, u.length - 2)
      .map((paren) => {
        if (paren === ")") return "(";
        else if (paren === "(") return ")";
      })
      .join("");
    return "(" + fixParen(v) + ")" + temp;
  }
};

console.log(solution(ex1));
