const arr1 = [1, 1, 2, 2, 2, 2, 3];
const x1 = 4;

const solution = (arr, x) => {
  return findNum(arr, x);
};

const findNum = (arr, target) => {
  const startIdx = first(arr, 0, arr.length - 1, target);
  const finalIdx = second(arr, 0, arr.length - 1, target);
  if (startIdx === -1) return -1;
  return finalIdx - startIdx + 1;
};

const first = (arr, start, end, target) => {
  if (start > end) return -1;

  const mid = Math.floor((start + end) / 2);

  if ((mid === 0 || arr[mid - 1] < target) && arr[mid] === target) return mid;
  else if (arr[mid] >= target) return first(arr, start, mid - 1, target);
  else if (arr[mid] < target) return first(arr, mid + 1, end, target);
};

const second = (arr, start, end, target) => {
  if (start > end) return -1;

  const mid = Math.floor((start + end) / 2);

  if ((mid === arr.length - 1 || arr[mid + 1] > target) && arr[mid] === target)
    return mid;
  else if (arr[mid] > target) return second(arr, start, mid - 1, target);
  else if (arr[mid] <= target) return second(arr, mid + 1, end, target);
};

console.log(solution(arr1, x1));
