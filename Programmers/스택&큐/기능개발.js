const solution = (progresses, speeds) => {
  let p = progresses.slice();
  let s = speeds.slice();
  let count = 0;
  let answer = [];
  while (p.length > 0) {
    for (let i = 0; i < p.length; i++) {
      p[i] += s[i];
    }
    while (p[0] >= 100) {
      p.shift();
      s.shift();
      count++;
    }
    if (count !== 0) {
      answer.push(count);
      count = 0;
    }
  }

  return answer;
};

console.log(solution([93, 30, 55], [1, 30, 5]));
