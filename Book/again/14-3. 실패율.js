const n1 = 5;
const stages1 = [2, 1, 2, 6, 2, 4, 3, 3];
const n2 = 4;
const stages2 = [4, 4, 4, 4, 4];

function solution(n, stages) {
  stages.sort((a, b) => a - b);
  const result = [];
  for (let i = 1; i <= n; i++) {
    const stay = stages.filter((v) => v === i).length;
    const all = stages.filter((v) => v >= i).length;
    let failure = stay / all;
    if (all === 0) failure = 0;
    result.push({ stage: i, failure: failure });
  }
  return result.sort((a, b) => b.failure - a.failure).map((v) => v.stage);
}

console.log(solution(n2, stages2));
