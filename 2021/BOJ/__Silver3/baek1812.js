let test1 = [5, 7, 6];

function solution(n) {
  let sum = n.reduce((a, b) => {
    return a + b;
  });
  sum = sum / 2;
  let list = [];
  let temp = 0;
  for (let i = 0; i < n.length; i = i + 2) {
    if (i !== n.length - 1) temp += n[i];
  }
  let final = sum - temp;
  let index = 0;

  while (true) {
    if (list.length !== 0) {
      let user = list.reduce((a, b) => {
        return a + b;
      });

      if (user === sum - final) {
        list.push(final);
        break;
      }
    }

    let num;
    if (index === 0) {
      num = n[n.length - 1] - final;
    } else {
      num = n[index - 1] - list[index - 1];
    }
    list.push(num);

    index += 1;
  }
  return list;
}

console.log(solution(test1));
