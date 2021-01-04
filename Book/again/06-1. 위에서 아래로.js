/**
 * 내림차순 정렬 sort((a, b) => b - a)
 */

const data1 = [15, 27, 12];
const data2 = ["ab", "bb", "ac"];

function solution(data) {
  const number = /[0-9]+/;

  if (number.exec(data[0])) return data.sort((a, b) => b - a);
  else return data.sort((a, b) => (b > a ? 1 : -1));
}

console.log(solution(data2));
