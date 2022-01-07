function solution(n) {
  let count = 0;

  for (let i = 1; i <= n; i++) {
    for (let j = 1; j <= n; j++) {
      if (n === i * j + ((j - 1) * j) / 2) {
        count++;
        break;
      } else if (n < i * j + ((j - 1) * j) / 2) break;
    }
  }

  return count;
}

console.log(solution(15));
