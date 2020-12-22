let pobi1 = [97, 98];
let crong1 = [197, 198];
let pobi2 = [131, 132];
let crong2 = [211, 212];
let pobi3 = [99, 102];
let crong3 = [211, 212];

const solution = (pobi, crong) => {
  // 예외처리
  if (pobi[0] % 2 !== 1 || pobi[1] % 2 !== 0) return -1;
  if (crong[0] % 2 !== 1 || crong[1] % 2 !== 0) return -1;
  if (pobi[1] - pobi[0] !== 1 || crong[1] - crong[0] !== 1) return -1;

  let pobi_max = -1,
    crong_max = -1;

  pobi.forEach((v) => {
    let tempSum = 0,
      tempMul = 1;
    if (v < 10) {
      tempSum = v;
      tempMul = v;
    } else {
      String(v)
        .split("")
        .forEach((value) => {
          tempSum += Number(value);
          tempMul *= Number(value);
        });
    }
    let tempMax = Math.max.apply(null, [tempSum, tempMul]);
    if (tempMax > pobi_max) pobi_max = tempMax;
  });

  crong.forEach((v) => {
    let tempSum = 0,
      tempMul = 1;
    if (v < 10) {
      tempSum = v;
      tempMul = v;
    } else {
      String(v)
        .split("")
        .forEach((value) => {
          tempSum += Number(value);
          tempMul *= Number(value);
        });
    }
    let tempMax = Math.max.apply(null, [tempSum, tempMul]);
    if (tempMax > crong_max) crong_max = tempMax;
  });

  if (pobi_max === crong_max) return 0;
  if (pobi_max > crong_max) return 1;
  if (pobi_max < crong_max) return 2;
};

console.log(solution(pobi3, crong3));
