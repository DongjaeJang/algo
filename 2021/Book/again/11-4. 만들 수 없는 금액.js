const n = 5;
const coin = [3, 2, 1, 1, 9];
const coin2 = [1, 2, 3, 4, 5];

function permutation(numberList, cur, result) {
  let clone = numberList.slice();

  for (let i in clone) {
    let su = clone.shift();
    let temp = cur + su;
    if (!result.includes(temp)) result.push(temp);
    permutation(clone, temp, result);
    clone.push(su);
  }
}

function solution(n, coin) {
  const result = [];
  permutation(coin, 0, result);
  result.sort((a, b) => a - b);
  for (let i = 0; i < result.length; i++) {
    if (i + 1 !== result[i]) return i + 1;
  }
  return result[result.length - 1] + 1;
}

console.log(solution(n, coin2));
