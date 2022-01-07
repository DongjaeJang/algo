/* 피보나치 다이나믹 이용 */

const n1 = 100;
const array = [];

// 배열 초기화
const initialArray = (array, n) => {
  for (let i = 0; i <= n; i++) array.push(0);
};

// 피보나치 함수
const fibo = (n) => {
  // 탈출 조건 --- 1 or 2
  if (n === 1 || n === 2) return 1;
  // 이미 계산한 적 있는 수라면, 바로 배열에서 값 도출
  if (array[n]) return array[n];
  // 계산한 적이 없다면 새로 구해서 넣는다.
  array[n] = fibo(n - 1) + fibo(n - 2);
  return array[n];
};

initialArray(array, n1);

console.log(fibo(n1));
