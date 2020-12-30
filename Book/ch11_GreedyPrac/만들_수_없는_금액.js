const money1 = [3, 2, 1, 1, 9];

const solution = (money) => {
  const numberList = [...money].sort((a, b) => a - b);
  if (numberList[0] > 1) return 1;
  const moneyList = [];
  permutation(moneyList, 0, numberList);
  moneyList.sort((a, b) => a - b);
  for (let i = 1; i <= moneyList[moneyList.length - 1]; i++) {
    if (i !== moneyList[i - 1]) return i;
  }
};

// 모든 경우의 수를 구하는 순열
const permutation = (numberList, cur, card) => {
  // 배열의 원소를 다 사용했을 때 탈출
  if (card.length === 0) return;

  // 재귀로 사용할 배열. 얕은 복사
  let clone = card.slice();
  // 원소를 차례대로
  for (let i in card) {
    let su = clone.pop();
    let num = cur + su;
    // 이미 나온 수면 skip
    if (!numberList.includes(num)) numberList.push(num);
    permutation(numberList, cur + su, clone);
    clone.unshift(su);
  }
};

console.log(solution(money1));
