const n = 3;
const n2 = 20;

function solution(n) {
  const array = Array(n + 1);
  array[1] = 1;
  array[2] = 3;
  for (let i = 3; i <= n; i++)
    array[i] = (array[i - 1] + array[i - 2] * 2) % 796796;

  console.log(array);
  return array[n];
}

console.log(solution(n2));
