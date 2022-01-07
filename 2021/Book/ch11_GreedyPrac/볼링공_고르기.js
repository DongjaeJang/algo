const arr1 = [1, 3, 2, 3, 2];
const arr2 = [1, 5, 4, 3, 2, 4, 2, 5];

const solution = (arr) => {
  const max = Math.max.apply(null, arr);
  const min = Math.min.apply(null, arr);

  let answer = 0;
  for (let weight = min; weight < max; weight++) {
    const p = arr.filter((v) => v > weight).length;
    const su = arr.filter((v) => v === weight).length;
    answer += su * p;
  }

  return answer;
};

console.log(solution(arr1));
