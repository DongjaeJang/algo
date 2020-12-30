function solution(food_times, k) {
  const foodMax = food_times.reduce((acc, cur) => (acc += cur), 0);
  if (foodMax <= k) return -1;

  let foods = food_times
    .map((v, i) => {
      return { index: i + 1, time: v };
    })
    .sort((a, b) => a.time - b.time);
  let prevTime = 0;
  for (let i = 0; i < foods.length; i++) {
    const flen = foods.length - i;
    const minTime = foods[i].time - (i === 0 ? 0 : foods[i - 1].time);
    const cost = minTime * flen;
    if (k - cost > 0) {
      k -= cost;
    } else {
      return foods.slice(i).sort((a, b) => a.index - b.index)[k % flen].index;
    }
  }
}
// 5
console.log(solution([3, 1, 2]));
