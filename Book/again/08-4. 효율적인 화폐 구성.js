/**
 * target을 낼 때 필요한 최소 화폐 갯수 출력
 * 불가능하다면 -1 출력
 */

const target = 15;
const coin = [2, 3];
const target2 = 4;
const coin2 = [3, 5, 7];

function solution(target, coin) {
  const INF = 987654321;
  const array = Array(target + 1).fill(INF);
  // 있는 동전은 1로 만든다.
  for (let i = 0; i < coin.length; i++) {
    const current = coin[i];
    array[current] = 1;
  }
  coin.sort((a, b) => a - b);
  for (let i = coin[0]; i <= target; i++) {
    for (let j = 0; j < coin.length; j++) {
      if (i - coin[j] >= 0) {
        if (array[i - coin[j]] !== INF)
          array[i] = Math.min(array[i], array[i - coin[j]] + 1);
      }
    }
  }
  console.log(array);
  return array[target] !== INF ? array[target] : -1;
}

console.log(solution(target2, coin2));
