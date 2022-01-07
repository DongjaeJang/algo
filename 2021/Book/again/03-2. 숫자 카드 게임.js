/**
 * 뽑은 카드의 행에서 가장 작은 숫자를 뽑아야 된다.
 * => 행의 최솟값들 중 최댓값을 구하여 출력
 */
const cardList1 = [
  [3, 1, 2],
  [4, 1, 4],
  [2, 2, 2],
];
const cardList2 = [
  [7, 3, 1, 8],
  [3, 3, 3, 4],
];

function solution(cardList) {
  // 행에서 최솟값들만 모아서 minList 생성
  const minList = cardList.map((v) => Math.min.apply(null, v));
  // minList에서 최댓값 출력
  return Math.max.apply(null, minList);
}

console.log(solution(cardList1));
