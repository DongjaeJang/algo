function solution(string) {
  let problem = [];
  let answer = [];
  string
    .slice()
    .split("\n")
    .forEach((v) => {
      let temp = v.split(" ");
      problem.push([Number(temp[0]), Number(temp[1])]);
    });
  problem.forEach((v) => {
    for (let i = 1; i <= v[0] * v[1]; i++) {
      if (i % v[0] === 0 && i % v[1] === 0) {
        answer.push(i);
        break;
      }
    }
  });

  return answer;
}

console.log(solution("1 45000\n6 10\n13 17"));