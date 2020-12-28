// 소수인지 판단
const isSosu = (number) => {
  if (number < 2) return false;
  for (let i = 2; i < number; i++) {
    if (number % i === 0) return false;
  }
  return true;
};

// 순열
const permutation = (numberList, cur, card) => {
  // 배열의 원소를 다 사용했을 때 탈출
  if (card.length === 0) return;
  // 재귀로 사용할 배열. 얕은 복사
  let clone = card.slice();
  // 원소를 차례대로
  for (let i in card) {
    let su = clone.pop();
    let num = Number(cur + su);
    if (isSosu(num)) {
      numberList.push(num);
    }
    permutation(numberList, cur + su, clone);
    clone.unshift(su);
  }
};

const solution = (numbers) => {
  let card = numbers.slice().split("");
  let numberList = [];
  permutation(numberList, "", card);
  console.log(numberList);
  return [...new Set(numberList)].length;
};

console.log(solution("17"));
