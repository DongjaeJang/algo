const n1 = 5;
const list1 = [7, 3, 8, 8, 1, 0, 2, 7, 4, 4, 4, 5, 2, 6, 5];

function solution(n, list) {
  const list_ = list.slice();
  const tri = [];
  for (let i = 0; i < n; i++) {
    const temp = list_.splice(0, i + 1);
    tri.push(temp);
  }
  const dtri = tri.map((v) => v.slice());

  for (let i = 1; i < n; i++) {
    for (let j = 0; j <= i; j++) {
      if (j === 0) dtri[i][j] = dtri[i - 1][j] + tri[i][j];
      else if (j === i) dtri[i][j] = dtri[i - 1][j - 1] + tri[i][j];
      else
        dtri[i][j] = Math.max(dtri[i - 1][j], dtri[i - 1][j - 1]) + tri[i][j];
    }
  }
  return Math.max.apply(null, dtri[n - 1]);
}

console.log(solution(n1, list1));
