const food_times = [3, 1, 2];
const k = 5;

function solution(food_times, k) {
  const foodMax = food_times.reduce((acc, cur) => (acc += cur), 0);
  if (foodMax <= k) return -1;

  const foods = food_times
    .map((v, i) => {
      return { time: v, index: i + 1 };
    })
    .sort((a, b) => a.time - b.time);

  for (let i = 0; i < foods.length; i++) {
    const flen = foods.length - i;
    const spendTime = foods[i].time - (i === 0 ? 0 : foods[i - 1].time);
    if (k > spendTime * flen) k -= spendTime * flen;
    else {
      return foods.slice(i).sort((a, b) => a.index - b.index)[k % flen].index;
    }
  }
}

console.log(solution(food_times, k));
