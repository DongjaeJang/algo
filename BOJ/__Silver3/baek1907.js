let test1 = "C+CC=CCCCC";
let test2 = "HO3H2+O=H2O2O2";
function solution(str) {
  let temp = str.slice().split("=");
  let tempLeft = temp[0].split("+");
  let tempRight = temp[1];
  let digit = "0123456789";
  let left = [
    [0, 0, 0],
    [0, 0, 0],
  ];
  let right = [0, 0, 0];
  // C H O 순서
  // 좌변
  tempLeft.forEach((bunja, index) => {
    let before = "";
    bunja
      .slice()
      .split("")
      .forEach((wonja) => {
        if (digit.includes(wonja)) {
          let su = Number(wonja) - 1;
          for (let i = 0; i < su; i++) {
            if (before === "C") {
              left[index][0] += 1;
            } else if (before === "H") {
              left[index][1] += 1;
            } else if (before === "O") {
              left[index][2] += 1;
            }
          }
        } else {
          if (wonja === "C") {
            left[index][0] += 1;
          } else if (wonja === "H") {
            left[index][1] += 1;
          } else if (wonja === "O") {
            left[index][2] += 1;
          }
          before = wonja;
        }
      });
  });
  // 우변
  let before = "";
  tempRight
    .slice()
    .split("")
    .forEach((wonja) => {
      if (digit.includes(wonja)) {
        let su = Number(wonja) - 1;
        for (let i = 0; i < su; i++) {
          if (before === "C") {
            right[0] += 1;
          } else if (before === "H") {
            right[1] += 1;
          } else if (before === "O") {
            right[2] += 1;
          }
        }
      } else {
        if (wonja === "C") {
          right[0] += 1;
        } else if (wonja === "H") {
          right[1] += 1;
        } else if (wonja === "O") {
          right[2] += 1;
        }
        before = wonja;
      }
    });
  let l1, l2, r1;
  for (let j = 0; j < 3; j++) {
    l1 * left[0][j] + l2 * left[1][j] === r1 * right[j];
  }

  return right;
}

console.log(solution(test2));
