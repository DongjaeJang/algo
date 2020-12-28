const n1 = 4;
const m1 = 6;
const arr1 = [19, 15, 10, 17];
const n2 = 8;
const m2 = 18;
const arr2 = [10, 15, 17, 19, 11, 13, 14, 30];

const binarySearch = (array, target, answer) => {
  // 배열 중 가장 짧은 길이 = min
  // 배열 중 가장 긴 길이 = max
  let min = 0;
  let max = Math.max.apply(null, array);
  let count = 1;
  // min 이 max 보다 길어지는 순간 탈출
  while (min <= max) {
    const height = Math.floor((min + max) / 2);
    const sum = sumLength(array, height);

    console.log(
      `count : ${count++}, min : ${min}, max : ${max}, height : ${height}, sum : ${sum}`
    );
    // target 보다 길이가 짧으면 max를 줄인다.
    if (sum < target) {
      max = height - 1;
      // target 보다 길이가 길거나 같으면, min을 높이고 answer에 push
    } else {
      answer.push(height);
      min = height + 1;
    }
  }
};
// 자르고 난 뒤 떡 길이의 합
const sumLength = (array, height) => {
  return array
    .filter((current) => current - height > 0)
    .reduce((acc, cur) => {
      if (cur > 0) return (acc += cur - height);
    }, 0);
};

const solution = (n, m, arr) => {
  const answer = [];
  binarySearch(arr, m, answer);

  return Math.max.apply(null, answer);
};

console.log(solution(n1, m2, arr2));
