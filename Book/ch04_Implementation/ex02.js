const n1 = 5;

const solution = (n) => {
  let answer = 0;
  for (let hour = 0; hour <= n; hour++) {
    for (let minute = 0; minute < 60; minute++) {
      for (let second = 0; second < 60; second++) {
        const str = "" + hour + minute + second;
        if (str.includes("3")) answer++;
      }
    }
  }
  return answer;
};

console.log(solution(n1));
