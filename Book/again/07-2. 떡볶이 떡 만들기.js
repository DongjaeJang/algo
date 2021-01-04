/**
 * 높이의 최댓값을 구하는 문제
 * OO의 최댓값을 구하라는 OO을 이진탐색 기준으로 이용하면 되나?
 */
const m = 6;
const info = [19, 15, 10, 17];
const m2 = 10;
const info2 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 19, 17, 15, 16, 13];

function solution(m, info) {
  info.sort((a, b) => a - b);
  return binarySearch(m, info);
}

function binarySearch(m, info) {
  const ilen = info.length;
  let start = 0;
  let end = info[ilen - 1];
  let result = 0;

  while (start <= end) {
    const height = Math.floor((start + end) / 2);
    const afterCut = info
      .filter((len) => len > height)
      .reduce((acc, cur) => (acc += cur - height), 0);
    if (afterCut === m) return height;
    else if (afterCut < m) {
      end = height - 1;
    } else {
      start = height + 1;
      result = height;
    }
    console.log(`height : ${height}, start : ${start}, end : ${end}`);
  }
  return result;
}

console.log(solution(m2, info2));
