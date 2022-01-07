/**
 * === 이진 탐색 기본 ===
 * 1. 우선 searching 해야되는 배열을 오름차순으로 정렬한다.
 * 2. start, end 포인트를 정한다.
 * 3. 탈출 조건은 start가 end를 넘어서기 전까지
 * 4. mid 인덱스가 target과 같으면 멈추고, 아니라면 계속해서 binarySearch 진행
 */

const n = 5;
const infoN = [8, 3, 7, 9, 2];
const m = 3;
const infoM = [5, 7, 9];

function solution(n, infoN, m, infoM) {
  infoN.sort((a, b) => a - b);
  const result = [];
  infoM.forEach((target) => {
    result.push(binarySearch(infoN, target));
  });
  return result;
}

function binarySearch(info, target) {
  let start = 0;
  let end = info.length - 1;

  while (start <= end) {
    const mid = Math.floor((start + end) / 2);
    if (info[mid] === target) return "yes";
    else if (info[mid] < target) start = mid + 1;
    else end = mid - 1;
  }
  return "no";
}

console.log(solution(n, infoN, m, infoM));
