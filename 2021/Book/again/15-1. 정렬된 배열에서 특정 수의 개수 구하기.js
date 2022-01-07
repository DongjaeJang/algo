const n = 7;
const x = 2;
const list = [1, 1, 2, 2, 2, 2, 3];
const x2 = 4;
const list2 = [1, 1, 2, 2, 2, 2, 3];

function solution(n, x, list) {
  list.sort((a, b) => a - b);
  const leftidx = left(list, x);
  const rightidx = right(list, x);
  return leftidx === -1 ? -1 : rightidx - leftidx + 1;
}

function left(list, target) {
  let start = 0;
  let end = list.length - 1;

  while (start <= end) {
    const mid = Math.floor((start + end) / 2);
    if ((mid === 0 || list[mid - 1] < target) && list[mid] === target)
      return mid;
    else if (list[mid] < target) start = mid + 1;
    else if (list[mid] >= target) end = mid - 1;
  }
  return -1;
}

function right(list, target) {
  let start = 0;
  let end = list.length - 1;

  while (start <= end) {
    const mid = Math.floor((start + end) / 2);
    if (
      (mid === target.length - 1 || list[mid + 1] > target) &&
      list[mid] === target
    )
      return mid;
    else if (list[mid] <= target) start = mid + 1;
    else if (list[mid] > target) end = mid - 1;
  }
  return -1;
}

console.log(solution(n, x2, list2));
