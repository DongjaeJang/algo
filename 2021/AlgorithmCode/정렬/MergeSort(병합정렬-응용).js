/**
 * 목적 : 배열을 정렬해서 나열했을 때, 가장 큰 수가 나오도록 한다
 * 방법 : 정렬을 진행할 때, ( left[0] + right[0] ) 이 큰지 ( right[0] + left[0] )이 큰지 비교한다.
 */

let array = [5, 1, 4, 3, 10, 8, 7, 6];

const merge = (left, right) => {
  const result = [];
  // 합친 후 비교를 위해 String으로 변환
  left = left.map((v) => String(v));
  right = right.map((v) => String(v));
  while (left.length > 0 && right.length > 0) {
    // 좌+우 / 우+좌 크기 비교
    if (left[0] + right[0] > right[0] + left[0]) result.push(left.shift());
    else result.push(right.shift());
  }
  return [...result, ...left, ...right];
};

const mergeSort = (list) => {
  if (list.length === 1) return list;
  const mid = Math.floor(list.length / 2);
  const left = list.slice(0, mid);
  const right = list.slice(mid);
  return merge(mergeSort(left), mergeSort(right));
};

// 876543110
console.log(mergeSort(array).join(""));
