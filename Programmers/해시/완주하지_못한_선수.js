const p1 = ["leo", "kiki", "eden"];
const c1 = ["eden", "kiki"];
const p2 = ["marina", "josipa", "nikola", "vinko", "filipa"];
const c2 = ["josipa", "filipa", "marina", "nikola"];

const solution = (participant, completion) => {
  let hash = [];
  let plen = participant.length;
  let clen = completion.length;
  // hash에 참가자 추가
  for (let i = 0; i < plen; i++) {
    const sunsu = participant[i];
    hash[sunsu] = hash[sunsu] ? hash[sunsu] + 1 : 1;
  }
  // hash에서 완주자 만큼 삭제
  for (let i = 0; i < clen; i++) {
    const sunsu = completion[i];
    hash[sunsu]--;
  }
  // hash에서 0값이 아닌 선수가 완주 못한 사람이므로
  for (let key in hash) {
    if (hash[key]) return key;
  }
};

console.log(solution(p1, c1));
