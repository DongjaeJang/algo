const n1 = 5;
const arr1 = [8, 3, 7, 9, 2, 1, 5, 10, 1111, 12];
const m1 = 3;
const arr2 = [5, 7, 9, 866151];

// 해시 풀이
const solution = (n, arr1, m, arr2) => {
  const answer = [];
  const hash = arr1.reduce((acc, cur) => {
    if (!acc[cur]) acc[cur] = 0;
    acc[cur] += 1;
    return acc;
  }, []);
  arr2.forEach((v) => {
    hash[v] ? answer.push("yes") : answer.push("no");
  });
  return answer;
};

console.log(solution(n1, arr1, m1, arr2));
