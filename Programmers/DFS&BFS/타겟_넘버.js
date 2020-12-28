const dfs = (list, index, sum, target, answer) => {
  if (index === list.length) {
    if (sum === target) {
      answer.push(sum);
    }
    return;
  }
  dfs(list, index + 1, sum + list[index], target, answer);
  dfs(list, index + 1, sum - list[index], target, answer);
};

const solution = (numbers, target) => {
  const answer = [];
  dfs(numbers, 0, 0, target, answer);

  return answer.length;
};

console.log(solution([1, 1, 1, 1, 1], 3));
