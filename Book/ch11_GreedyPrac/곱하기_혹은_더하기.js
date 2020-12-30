const str1 = "02984";
const str2 = "11111";
const str3 = "4";
const str4 = "000000005";
const str5 = "123456";

const solution = (str) => {
  let answer = 0;
  const numberList = str.split("").map((v) => Number(v));
  numberList.forEach((num, idx) => {
    if (idx === 0) answer = num;
    else {
      if (answer < 2) answer += num;
      else {
        if (num < 2) answer += num;
        else answer *= num;
      }
    }
  });
  return answer;
};

console.log(solution(str1));
