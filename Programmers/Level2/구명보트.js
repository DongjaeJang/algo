/**
 * 기존 배열을 정렬하고,
 * 1. 맨 뒤값을 뽑는다.
 * 2. 맨 앞값을 더해도 limit을 안넘으면 계속해서 앞값을 뽑으면서 더해준다.
 * 3. 더 못넣는다면 break하고 보트 갯수를 늘린다.
 */

const solution = (people, limit) => {
  let answer = 0;
  let p = [...people].sort((a, b) => a - b);

  while (p.length > 0) {
    let max = p.pop();
    while (true) {
      if (max + p[0] <= limit) {
        max += p.shift();
      } else {
        break;
      }
    }
    answer += 1;
  }
  return answer;
};

console.log(solution([70, 50, 80, 50]));
