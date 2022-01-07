const str1 = "0001100";
const str2 = "10100111100";
const str3 = "000000000";
const str4 = "10010101011";

const solution = (str) => {
  const numberList = str.split("");
  const splitList = [];
  let tempStr = "";
  numberList.forEach((num, idx) => {
    if (idx === 0) tempStr += num;
    else {
      if (tempStr === num) tempStr += num;
      else {
        splitList.push(tempStr);
        tempStr = "" + num;
      }
    }
  });
  if (tempStr.length !== 0) splitList.push(tempStr);
  const set0 = splitList.filter((v) => v[0] === "0").length;
  const set1 = splitList.filter((v) => v[0] === "1").length;

  return Math.min(set0, set1);
};

console.log(solution(str4));
