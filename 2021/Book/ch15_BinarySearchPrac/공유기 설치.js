const c1 = 3;
const house1 = [1, 2, 8, 4, 9];

const solution = (house, c) => {
  house.sort((a, b) => a - b);
  return binarySearch(house, c);
};
/**
 * 집을 정렬해놓고 거리를 기준으로 이진탐색을 진행한다.
 * min은 거리가 최소가 될때
 * max는 거리가 최대가 될때이다.
 */
const binarySearch = (house, c) => {
  let min = house[1] - house[0];
  let max = house[house.length - 1] - house[0];
  const hlen = house.length;
  let result = 0;

  while (min <= max) {
    const mid = Math.floor((min + max) / 2);
    let value = house[0];
    let count = 1;
    for (let i = 1; i < hlen; i++) {
      if (house[i] >= value + mid) {
        value = house[i];
        count++;
      }
    }
    if (count >= c) {
      min = mid + 1;
      result = mid;
    } else {
      max = mid - 1;
    }
  }

  return result;
};

console.log(solution(house1, c1));
