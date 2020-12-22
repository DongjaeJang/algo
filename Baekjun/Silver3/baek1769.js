function solution(n) {
  if (n < 10) {
    if (n % 3 === 0) return "" + 0 + "\n" + "Yes";
    else return "" + 0 + "\n" + "No";
  }
  let answer = "";
  let tempNum = String(n)
    .split("")
    .reduce((a, b) => {
      return Number(a) + Number(b);
    });
  let solve = 1;

  let temp = String(tempNum);
  while (temp.length !== 1) {
    let t = temp.split("").reduce((a, b) => {
      return Number(a) + Number(b);
    });
    solve += 1;
    temp = String(t);
  }
  Number(temp) % 3 === 0 ? (answer = "Yes") : (answer = "No");

  return "" + solve + "\n" + answer;
}

console.log(solution(88888));
