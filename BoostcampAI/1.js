function solution(s) {
  let answer = 0;

  const hash = [];
  for (let i = 0; i < s.length; i++) {
    if (!hash[s[i]]) hash[s[i]] = 0;

    hash[s[i]]++;
  }

  for (let key in hash) {
    if (hash[key] % 2 === 1) answer++;
  }
  return answer;
}

console.log(solution("aabbbccd"));
