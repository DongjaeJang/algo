// 최소한의 화폐 갯수 출력
// 불가능할 시 -1 출력
const n1 = 2;
const m1 = 15;
const coin1 = [2, 3];

const n2 = 3;
const m2 = 4;
const coin2 = [3, 5, 7];

const array = [];
const initialArray = (array) => {
  for (let i = 0; i <= 10000; i++) array.push(10001);
};

const dp = (array, coinSet) => {
  array[0] = 0;
  for (let i = 0; i < coinSet.length; i++) {
    for (let j = coinSet[i]; j < 10001; j++) {
      array[j] = Math.min(array[j], array[j - coinSet[i]] + 1);
    }
  }
};
initialArray(array);
dp(array, coin2);
console.log(array);
let answer = array[m2] === 10001 ? -1 : array[m2];

console.log(answer);
