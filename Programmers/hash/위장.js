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
