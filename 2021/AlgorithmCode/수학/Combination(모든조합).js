/**
 * 프로그래머스 Level 2 - 위장에서 쓰임.
 * 최소한 하나라도 입어야할 때, 나올 수 있는 모든 경우
 * 옷의 갯수가 3개라면 입지 않았을 때를 포함해서 나올 수 있는 경우가 4 == 옷 갯수 + 1
 * 총 경우의 수 = (각 종류의 옷 수 + 1)의 곱 - 1  ====> -1은 아무것도 걸치지 않은 경우
 */

const c1 = [
  ["yellow_hat", "headgear"],
  ["blue_sunglasses", "eyewear"],
  ["green_turban", "headgear"],
];
const c2 = [
  ["crow_mask", "face"],
  ["blue_sunglasses", "face"],
  ["smoky_makeup", "face"],
];

const solution = (clothes) => {
  let answer = 1;

  const hash = clothes.reduce((acc, cur) => {
    if (!acc[cur[1]]) {
      acc[cur[1]] = 0;
    }
    acc[cur[1]] += 1;
    return acc;
  }, []);

  for (let key in hash) answer *= hash[key] + 1;

  return answer - 1;
};

console.log(solution(c1));
