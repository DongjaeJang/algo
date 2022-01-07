const users1 = [2, 3, 1, 2, 2];
const users2 = [1, 2, 3, 4, 5, 7];
const users3 = [1, 1, 1, 1, 1, 1, 2];

const solution = (users) => {
  let answer = 0;
  let userList = users.slice().sort((a, b) => b - a);
  let group = [];
  while (userList.length > 0) {
    const temp = userList.shift();
    group.push(temp);
    const glen = group.length;
    if (glen === group[0]) {
      answer += 1;
      group = [];
    }
  }
  // userList가 다 비었지만 그룹에 남아있는 사람이 있을 경우 answer + 1
  if (group.length !== 0) answer += 1;

  return answer;
};

console.log(solution(users1));
