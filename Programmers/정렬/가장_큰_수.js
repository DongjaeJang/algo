const merge = (left, right) => {
  const result = [];
  left = left.map((v) => String(v));
  right = right.map((v) => String(v));
  while (left.length > 0 && right.length > 0) {
    if (left[0] + right[0] > right[0] + left[0]) result.push(left.shift());
    else result.push(right.shift());
  }
  return [...result, ...left, ...right];
};

const merge_sort = (list) => {
  if (list.length === 1) return list;
  const mid = Math.floor(list.length / 2);
  const left = list.slice(0, mid);
  const right = list.slice(mid);
  return merge(merge_sort(left), merge_sort(right));
};

const solution = (numbers) => {
  let list = merge_sort(numbers);
  return list[0] === "0" ? "0" : list.join("");
};

console.log(solution([6, 10, 2]));
