let word1 = "I love you";

const solution = (word) => {
  let bigAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  let smallAlpha = "abcdefghijklmnopqrstuvwxyz";
  let bigAlpha_reverse = bigAlpha.split("").reverse().join("");
  let smallAlpha_reverse = smallAlpha.split("").reverse().join("");

  let answer = "";

  word.split("").forEach((v) => {
    if (v === " ") answer += " ";
    else if (bigAlpha.includes(v)) {
      let idx = bigAlpha.indexOf(v);
      answer += bigAlpha_reverse[idx];
    } else if (smallAlpha.includes(v)) {
      let idx = smallAlpha.indexOf(v);
      answer += smallAlpha_reverse[idx];
    }
  });

  return answer;
};

console.log(solution(word1));
