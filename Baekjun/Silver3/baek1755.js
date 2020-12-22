function solution(m, n) {
  let answer = "";
  let number = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
  let letter = [
    "zero",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
  ];
  let temp = [];
  for (let i = m; i <= n; i++) {
    temp.push(i);
  }
  let tempAns = [];

  // 숫자를 영어로 바꿔줌
  temp.forEach((v) => {
    let str = "";
    if (v < 10) {
      let idx = number.indexOf(v);
      str = letter[idx];
      tempAns.push(str);
    } else {
      let tempStr = String(v).split("");
      tempStr.forEach((s, i) => {
        if (i === 1) str += " ";
        let number_idx = number.indexOf(Number(s));
        str += letter[number_idx];
      });
      tempAns.push(str);
    }
  });
  tempAns.sort((a, b) => {
    return a < b ? -1 : 1;
  });
  // 다시 영어를 숫자로
  tempAns.forEach((v, i) => {
    let tempNum = v.split(" ");
    let temp_s = "";
    tempNum.forEach((s) => {
      let letter_idx = letter.indexOf(s);
      temp_s += number[letter_idx];
    });
    answer += Number(temp_s);
    if (i !== tempAns.length - 1 && (i + 1) % 10 !== 0) answer += " ";
    if ((i + 1) % 10 === 0) {
      answer += "\n";
    }
  });

  return answer;
}

console.log(solution(8, 28));
