const str1 = "02984";
const str2 = "567";

function solution(str) {
  if (str.length === 1) return Number(str);
  const numberList = str.split("").map((v) => Number(v));
  let result = numberList.shift();
  for (let i = 0; i < numberList.length; i++) {
    const current = numberList[i];
    if (current <= 1) result += current;
    else {
      if (result < 2) result += current;
      else result *= current;
    }
  }
  return result;
}

console.log(solution(str2));
