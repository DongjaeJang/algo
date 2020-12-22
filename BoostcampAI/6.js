function solution(nums) {
  let answerList = [];
  let start = 0;
  let end = nums.length - 1;
  let count = 0;
  let route = [];

  dfs(nums, start, end, answerList, count, route);
  console.log(answerList);
  return answerList.length === 0 ? -1 : Math.min.apply(null, answerList);
}

function dfs(list, start, end, result, count, route) {
  if (start === end) {
    result.push(count);
    return;
  }

  if (start > end || start < 0) return;

  if (route.length === 0) {
    route.push(start);
    count++;

    if (list[start + list[start]] !== 0)
      dfs(list, start + list[start], end, result, count, route);
    if (list[start - list[start]] !== 0)
      dfs(list, start - list[start], end, result, count, route);
  } else {
    if (route.includes(start)) {
      return;
    } else {
      route.push(start);
      count++;
      if (list[start + list[start]] !== 0)
        dfs(list, start + list[start], end, result, count, route);
      if (list[start - list[start]] !== 0)
        dfs(list, start - list[start], end, result, count, route);
    }
  }
}

console.log(solution([4, 1, 2, 3, 1, 0, 5]));
