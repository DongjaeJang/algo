const n1 = 5;
const info1 = [-15, -6, 1, 3, 7];
const n2 = 7;
const info2 = [-15, -4, 2, 8, 9, 13, 15];
const n3 = 7;
const info3 = [-15, -4, 3, 8, 9, 13, 15];

function solution(n, info) {
  return binarySearch(info);
}

function binarySearch(info) {
  let start = 0;
  let end = info.length - 1;

  while (start <= end) {
    const mid = Math.floor((start + end) / 2);
    if (mid === info[mid]) return mid;
    else if (mid > info[mid]) start = mid + 1;
    else end = mid - 1;
  }
  return -1;
}

console.log(solution(n3, info3));
