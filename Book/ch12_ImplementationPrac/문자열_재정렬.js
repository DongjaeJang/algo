const str1 = "K1KA5CB7";
const str2 = "AJKDLSI412K4JSJ9D";
/**
 * 정규표현식 사용.
 * g 로 전역 탐색
 * 대상.match(정규표현식) ==> 해당하는 문자열을 다 뽑아줌
 */
const solution = (str) => {
  const number = /[0-9]+/g;
  const alphabet = /[A-Z]+/g;
  const numberOnly = str
    .match(number)
    .join("")
    .split("")
    .reduce((acc, cur) => (acc += Number(cur)), 0);
  const alphabetOnly = str
    .match(alphabet)
    .join("")
    .split("")
    .sort((a, b) => (a > b ? 1 : -1));
  return alphabetOnly.concat(numberOnly).join("");
};

console.log(solution(str2));
