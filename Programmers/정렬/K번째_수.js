const merge = (left, right) => {
  const result = [];
  while (left.length > 0 && right.length > 0) {
    if (left[0] <= right[0]) result.push(left.shift());
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

const solution = (array, commands) => {
  const answer = [];
  const clen = commands.length;
  for (let i = 0; i < clen; i++) {
    const [start, end, target] = commands[i];
    const temp_array = array.slice(start - 1, end);
    const sort_array = merge_sort(temp_array);
    answer.push(sort_array[target - 1]);
  }
  return answer;
};

console.log(
  solution(
    [1, 5, 2, 6, 3, 7, 4],
    [
      [2, 5, 3],
      [4, 4, 1],
      [1, 7, 3],
    ]
  )
);
