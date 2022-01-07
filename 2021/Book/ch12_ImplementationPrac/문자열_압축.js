const str1 = "aabbaccc";
const str2 = "ababcdcdababcdcd";
const str3 = "abcabcdede";
const str4 = "abcabcabcabcdededededede";
const str5 = "xababcdcdababcdcd";

const solution = (str) => {
  const max = Math.floor(str.length / 2);
  const answer = [];

  for (let i = 1; i <= max; i++) {
    let temp = str.split("");
    const s = [];
    while (temp.length > 0) {
      const substr = temp.splice(0, i).join("");
      s.push(substr);
    }
    const slist = [];
    while (s.length > 0) {
      const current = s.shift();
      if (slist.length === 0) slist.push(current);
      else {
        const prev = slist.pop();
        if (prev === current) {
          if (slist.length === 0) {
            slist.push(2);
            slist.push(current);
          } else {
            if (isNaN(slist[slist.length - 1])) {
              slist.push(2);
              slist.push(current);
            } else {
              slist[slist.length - 1] += 1;
              slist.push(current);
            }
          }
        } else {
          slist.push(prev);
          slist.push(current);
        }
      }
    }
    answer.push(slist.join("").length);
  }
  return answer.sort((a, b) => a - b)[0];
};

console.log(solution(str1));
