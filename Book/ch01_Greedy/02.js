const ex1 = [3, 3];
const arr1 = [
  [3, 1, 2],
  [4, 1, 4],
  [2, 2, 2],
];
const ex2 = [2, 4];
const arr2 = [
  [7, 3, 1, 8],
  [3, 3, 3, 4],
];
const solution = (ex, arr) => {
  const [N, M] = ex;
  const array = [...arr];
  let answer = 0;
  // 각 행마다 최솟값(target)을 찾고 answer 보다 크면 answer에 값을 넣어준다.
  for (let i = 0; i < N; i++) {
    let target = Math.min.apply(null, array[i]);
    if (answer < target) answer = target;
  }
  return answer;
};

console.log(solution(ex2, arr2));
