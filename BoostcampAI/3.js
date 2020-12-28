const solution = (N, sequence) => {
  let answer = 0;
  const house = [];
  // 집 순서 배열
  for (let i = 0; i < N; i++) {
    house.push(i + 1);
  }

  let hlen = house.length;
  let mid = hlen / 2;

  let currentIdx = 0;
  let slen = sequence.length;

  // 현재 위치에서 타겟 위치까지 거리가 mid를 넘는다면, 반대로 가는 것이 빠르다.
  for (let i = 0; i < slen; i++) {
    const target = sequence[i];
    const targetIdx = house.indexOf(target);
    const clockwise = Math.abs(targetIdx - currentIdx);
    if (clockwise <= mid) {
      answer += clockwise;
    } else {
      answer += hlen - clockwise;
    }
    currentIdx = targetIdx;
  }
  return answer;
};

console.log(solution(5, [2, 5, 3, 4, 1]));
