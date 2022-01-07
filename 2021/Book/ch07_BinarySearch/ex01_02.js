const arr1 = [1, 3, 5, 7, 9, 11, 13, 15, 17, 19];

const binarySearch = (array, start, end, target) => {
  while (true) {
    // start가 end를 넘으면 배열안에 존재하지 않는 것이므로 break;
    if (start > end) break;
    const mid = Math.floor((start + end) / 2);
    if (array[mid] === target) return mid;
    else if (array[mid] < target) {
      start = mid + 1;
    } else {
      end = mid - 1;
    }
  }
  return "Cannot find";
};

const solution = (array) => {
  let idx = binarySearch(array, 0, array.length - 1, 8);
  return idx;
};

console.log(solution(arr1));
