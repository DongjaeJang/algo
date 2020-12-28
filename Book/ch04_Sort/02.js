const ex1 = [
  ["홍길동", 95],
  ["이순신", 77],
];

const solution = (arr) => {
  return arr.sort((a, b) => a[1] - b[1]).map((name) => name[0]);
};

console.log(solution(ex1));
