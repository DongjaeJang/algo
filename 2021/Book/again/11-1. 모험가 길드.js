const n = 5;
const people = [2, 3, 1, 2, 2];

function solution(n, people) {
  // 오름차순 정렬
  people.sort((a, b) => a - b);
  let count = 0;
  let temp = [];
  for (let i = 0; i < n; i++) {
    temp.push(people[i]);
    if (temp[temp.length - 1] === temp.length) {
      count += 1;
      temp = [];
    }
  }
  return count;
}

console.log(solution(n, people));
