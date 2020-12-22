function solution(arr) {
  if (arr.length === 1) {
    if (arr[0] === 1) return 0;
    else return 1;
  }

  let answer = 0;
  let array = [...arr];

  while (true) {
    let compareArray = [];
    for (let i = 0; i < array.length; i++) {
      if (i === 0) {
        compareArray.push({ num: array[0], count: 1 });
      } else {
        if (compareArray[compareArray.length - 1].num === array[i]) {
          compareArray[compareArray.length - 1].count += 1;
        } else {
          compareArray.push({ num: array[i], count: 1 });
        }
      }
    }
    let compare = compareArray.map((v) => v.count);

    if (
      array.length === 1 &&
      compare.length === 1 &&
      array[0] === 1 &&
      compare[0] === 1
    )
      break;

    array = [...compare];
    answer++;
  }

  return answer;
}

console.log(solution([1, 1, 3, 3, 2, 2, 4, 5, 1, 1, 1, 3, 3, 3]));
