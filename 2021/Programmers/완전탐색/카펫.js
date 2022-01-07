const solution = (brown, yellow) => {
  return findRowCol(brown, yellow);
};
// 블록 조건 충족 : row * col === total
// 정확한 블록 충족 : (row - 2) * (col - 2) === yellow
// 모든 경우의 수에 접근하려고 하면 시간초과
// --> 약수의 개수들만 따로 모아놓고 진행하면 빠름
const findRowCol = (brown, yellow) => {
  let total = brown + yellow;
  let yaksu = findYaksu(total);
  if (yaksu.length === 1) return [yaksu[0], yaksu[0]];
  if (yaksu.length === 2) return [yaksu[1], yaksu[0]];
  let rowList = yaksu
    .slice()
    .reverse()
    .splice(0, yaksu.length / 2 + 1);
  let colList = yaksu.slice().splice(0, yaksu.length / 2 + 1);
  for (let i = 0; i < rowList.length; i++) {
    if ((rowList[i] - 2) * (colList[i] - 2) === yellow)
      return [rowList[i], colList[i]];
  }
  return yaksu;
};
// 약수 구하기
const findYaksu = (total) => {
  let yaksu = [];
  for (let i = 3; i < parseInt(total / 3) + 1; i++) {
    if (total % i === 0) yaksu.push(i);
  }
  return yaksu;
};

console.log(solution(10, 2));
