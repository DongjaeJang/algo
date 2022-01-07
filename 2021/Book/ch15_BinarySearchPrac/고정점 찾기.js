const arr1 = [-15, -6, 1, 3, 7];
const arr2 = [-15, -4, 2, 8, 9, 13, 15];
const arr3 = [-15, -7, 3, 8, 9, 13, 15];

const solution = (arr) => {
  return binarySearch(arr);
};

const binarySearch = (arr) => {
  let start = 0;
  let end = arr.length - 1;

  while (start <= end) {
    const mid = Math.floor((start + end) / 2);
    const current = arr[mid];

    if (current === mid) return mid;
    else if (current > mid) end = mid - 1;
    else start = mid + 1;
  }

  return -1;
};

console.log(solution(arr3));
