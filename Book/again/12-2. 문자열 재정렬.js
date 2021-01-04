const str = "K1KA5CB7";
const str2 = "AJKDLSI412K4JSJ9D";

function solution(str) {
  const number = "0123456789".split("");
  const alphabetList = [];
  const numList = [];
  str.split("").forEach((v) => {
    if (number.includes(v)) numList.push(Number(v));
    else alphabetList.push(v);
  });
  return (
    alphabetList.sort((a, b) => (a > b ? 1 : -1)).join("") +
    numList.reduce((acc, cur) => (acc += cur), 0)
  );
}

console.log(solution(str2));
