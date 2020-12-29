/**
 * 머지 소트
 * 시간복잡도 : O(nlogn)
 * => 분할하는 과정 : O(logn), 병합하는 과정 : O(n)
 * ==> O(nlogn)
 */

let array = [5, 1, 4, 3, 10, 8, 7, 6];

// 반으로 나눈 배열을 정렬해주는 함수
const merge = (left, right) => {
  const result = [];
  while (left.length > 0 && right.length > 0) {
    if (left[0] > right[0]) result.push(right.shift());
    else result.push(left.shift());
  }
  return [...result, ...left, ...right];
};

// 배열을 반으로 나눠주는 함수
// 길이가 1이면 정렬할 필요가 없으므로 그대로 return 해준다.
const mergeSort = (list) => {
  if (list.length === 1) return list;
  const mid = Math.floor(list.length / 2);
  const left = list.slice(0, mid);
  const right = list.slice(mid);
  return merge(mergeSort(left), mergeSort(right));
};

// [1, 3, 4, 5, 6, 7, 8, 10]
console.log(mergeSort(array));
