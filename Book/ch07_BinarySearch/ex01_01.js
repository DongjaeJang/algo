const arr1 = [1, 3, 5, 7, 9, 11, 13, 15, 17, 19];

const binarySearch = (array, start, end, target) => {
  if (start > end) return false;

  const mid = Math.floor((start + end) / 2);
  if (array[mid] === target) return mid;
  else if (array[mid] < target) {
    start = mid + 1;
    return binarySearch(array, start, end, target);
  } else {
    end = mid - 1;
    return binarySearch(array, start, end, target);
  }
};

const solution = (array) => {
  let idx = binarySearch(array, 0, array.length - 1, 7);
  return idx;
};

console.log(solution(arr1));
