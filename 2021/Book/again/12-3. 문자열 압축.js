const str1 = "aabbaccc";
const str2 = "ababcdcdababcdcd";
const str3 = "abcabcdede";
const str4 = "abcabcabcabcdededededede";
const str5 = "xababcdcdababcdcd";

function solution(str) {
  const result = [];
  const slen = Math.floor(str.length / 2);
  for (let i = 1; i <= slen; i++) {
    let tempList = [];
    let tempStr = str.split("");
    while (tempStr.length > 0) {
      const temp = tempStr.splice(0, i).join("");
      if (tempList.length === 0) tempList.push(temp);
      else {
        if (tempList[tempList.length - 1] === temp) {
          if (tempList.length === 1) {
            tempList.pop();
            tempList.push(2);
            tempList.push(temp);
          } else if (isNaN(tempList[tempList.length - 2])) {
            tempList.pop();
            tempList.push(2);
            tempList.push(temp);
          } else {
            tempList[tempList.length - 2] += 1;
          }
        } else {
          tempList.push(temp);
        }
      }
    }
    result.push(tempList.join("").length);
  }
  return result.sort((a, b) => a - b)[0];
}

console.log(solution(str4));
