const n1 = 5;
const stages1 = [2, 1, 2, 6, 2, 4, 3, 3];
const n2 = 4;
const stages2 = [4, 4, 4, 4, 4];

const solution = (n, stages) => {
  const result = [];
  for (let current = 1; current <= n; current++) {
    const stay = stages.filter((v) => v === current).length;
    const all = stages.filter((v) => v >= current).length;
    const failure = stay / all;
    if (all === 0) failure = 0;
    result.push({ stage: current, failure: failure });
  }
  return result.sort((a, b) => b.failure - a.failure).map((v) => v.stage);
};

console.log(solution(n2, stages2));
