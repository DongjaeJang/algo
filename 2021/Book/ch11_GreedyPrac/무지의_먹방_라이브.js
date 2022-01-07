function solution(food_times, k) {
  // 음식을 다 먹는 데 걸리는 시간보다 k가 크거나 같으면, 더 먹을 음식이 없으므로 -1 리턴
  const timeMax = food_times.reduce((acc, cur) => (acc += cur), 0);
  if (timeMax <= k) return -1;

  // 기존 배열을 {index, time} 객체로 변환하여, time으로 오름차순 정렬
  const foods = food_times
    .map((v, i) => {
      return { index: i + 1, time: v };
    })
    .sort((a, b) => a.time - b.time);

  for (let i = 0; i < foods.length; i++) {
    const flen = foods.length - i;
    const spendTime = foods[i].time - (i === 0 ? 0 : foods[i - 1].time);
    // 해당 차례의 음식을 다 먹는데까지 걸리는 시간
    // 1. k가 해당 시간보다 크다면 빼주면되고,
    // 2. 작다면 index를 내보내준다.
    const cost = spendTime * flen;
    if (k - cost > 0) {
      k -= cost;
    } else {
      return foods.slice(i).sort((a, b) => a.index - b.index)[k % flen].index;
    }
  }
}
// 5
console.log(solution([3, 1, 2], 5));
