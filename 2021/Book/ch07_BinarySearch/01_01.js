const n1 = 5;
const arr1 = [8, 3, 7, 9, 2, 1, 5, 10, 1111, 12];
const m1 = 3;
const arr2 = [5, 7, 9, 866151];

// 이진탐색 풀이
const binarySearch = (array, target) => {
  let start = 0;
  let end = array.length - 1;
  while (start <= end) {
    const mid = Math.floor((start + end) / 2);
    if (array[mid] === target) {
      return "yes";
    } else if (array[mid] > target) {
      end = mid - 1;
    } else {
      start = mid + 1;
    }
  }
  return "no";
};

const solution = (n, arr1, m, arr2) => {
  const answer = [];
  arr1.sort((a, b) => a - b);
  arr2.forEach((target) => {
    let str = binarySearch(arr1, target);
    answer.push(str);
  });
  return answer;
};

console.log(solution(n1, arr1, m1, arr2));
