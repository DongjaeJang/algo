/**
 * 주어진 수들을 M번 더해서 가장 큰 수를 만드는 법칙
 * 연속 K번 이하로 사용 가능
 */
const info = [5, 8, 3];
const numberList = [2, 4, 5, 4, 6];

function solution(info, numberList) {
  const [N, M, K] = info;
  // 정렬 --- 가장 큰 수와 두번째로 큰 수만 사용.
  numberList.sort((a, b) => b - a);
  const _1 = numberList[0]; // 가장 큰 수
  const _2 = numberList[1]; // 두번째 큰 수
  // 반복 횟수 구하기 -- (K * _1) + _ 2가 q만큼 반복
  const q = Math.floor(M / (K + 1));
  const r = M % (K + 1);

  return q * (K * _1 + _2) + r * _2;
}

console.log(solution(info, numberList));
