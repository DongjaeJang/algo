function solution(s) {
  const hash = [];
  const temp = s.split("");
  let answer = 0;

  for (let i = 0; i < temp.length; i++) {
    if (!hash[temp[i]]) hash[temp[i]] = 0;

    hash[temp[i]]++;
  }

  for (let key in hash) {
    if (hash[key] % 2 === 1) answer++;
  }
  return answer;
}

console.log(solution("aabbbccd"));
