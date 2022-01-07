/**
 * 퀵소트
 * 시간복잡도 : O(nlogn)      [최악의 경우 : O(n^2)]
 */
let array = [5, 1, 4, 3, 10, 8, 7, 6];

const quickSort = (list) => {
  const len = list.length;
  if (len === 0) return [];

  const left = [];
  const right = [];
  const pivot = list[0];

  for (let i = 1; i < len; i++) {
    if (list[i] < pivot) {
      left.push(list[i]);
    } else {
      right.push(list[i]);
    }
  }
  return quickSort(left).concat(pivot, quickSort(right));
};

// [1, 3, 4, 5, 6, 7, 8, 10]
console.log(quickSort(array));
