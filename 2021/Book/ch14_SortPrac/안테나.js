const arr1 = [5, 1, 7, 9];
const arr2 = [1, 7, 9];
const arr3 = [1, 3, 3, 3, 3, 3, 3, 7, 9];

const solution = (arr) => {
  const mid = Math.floor(arr.length / 2);
  arr.sort((a, b) => a - b);
  return mid % 2 === 1 ? arr[mid] : arr[mid - 1];
};

console.log(solution(arr1));
