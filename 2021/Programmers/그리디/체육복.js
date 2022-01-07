const solution = (n, lost, reserve) => {
  const hash = [];
  const llen = lost.length;
  const rlen = reserve.length;
  // n명의 학생 해시에 넣음
  for (let i = 1; i <= n; i++) hash[i] = 1;
  // 해시에서 여분있는 학생 +1
  for (let i = 0; i < rlen; i++) {
    let target = reserve[i];
    hash[target] += 1;
  }
  // 해시에서 잃어버린 학생 -1
  for (let i = 0; i < llen; i++) {
    let target = lost[i];
    hash[target] -= 1;
  }
  // 해시에서 +2인 경우만 주변 확인
  for (let i = 1; i <= n; i++) {
    let target = hash[i];
    if (target === 2) {
      if (i > 1 && i < n) {
        if (!hash[i - 1]) hash[i - 1] += 1;
        else if (!hash[i + 1]) hash[i + 1] += 1;
      } else if (i === 1) {
        if (!hash[i + 1]) hash[i + 1] += 1;
      } else if (i === n) {
        if (!hash[i - 1]) hash[i - 1] += 1;
      }
    }
  }

  return hash.filter((v) => v > 0).length;
};

console.log(solution(5, [2, 4], [1, 3, 5]));
