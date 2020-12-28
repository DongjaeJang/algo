const solution = (priorities, location) => {
  let p = priorities.map((v, i) => {
    return { index: i, value: v };
  });
  let answer = [];
  while (p.length > 0) {
    let first = p.shift();
    let others = p.filter((v) => {
      return v.value > first.value;
    });
    if (others.length > 0) p.push(first);
    else {
      answer.push(first);
      if (answer[answer.length - 1].index === location) {
        return answer.length;
      }
    }
  }
};

console.log(solution([2, 1, 3, 2], 2));
