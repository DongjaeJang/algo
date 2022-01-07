const str = "0001100";
const str2 = "1111";
function solution(str) {
  if ([...new Set(str)].length === 1) return 0;
  const zero = /[0]+/g;
  const one = /[1]+/g;

  const zeroSu = str.match(zero).length;
  const oneSu = str.match(one).length;

  return zeroSu < oneSu ? zeroSu : oneSu;
}

console.log(solution(str));
