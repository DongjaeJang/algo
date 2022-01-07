/**
 * 순열 (nPr)
 * ==> 서로 다른 n개 중에 r개를 이용해서 일렬로 세운다.
 */

// 모든 경우의 수를 구하는 순열 (1자리 수 ~ n자리 수까지 모두) (중복 X)
const permutation = (numberList, cur, card) => {
  // 배열의 원소를 다 사용했을 때 탈출
  if (card.length === 0) return;

  // 재귀로 사용할 배열. 얕은 복사
  let clone = card.slice();
  // 원소를 차례대로
  for (let i in card) {
    let su = clone.pop();
    let num = Number(cur + su);
    // 이미 나온 수면 skip
    if (!numberList.includes(num)) numberList.push(num);
    permutation(numberList, cur + su, clone);
    clone.unshift(su);
  }
};

const result = [];
permutation(result, "", [1, 7]);
// [1, 7, 17, 71]
console.log(result.sort((a, b) => a - b));
