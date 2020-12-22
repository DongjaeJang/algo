let money1 = 50237;
let money2 = 15000;

const solution = (money) => {
  let money_list = [50000, 10000, 5000, 1000, 500, 100, 50, 10, 1];
  let result = [0, 0, 0, 0, 0, 0, 0, 0, 0];
  let i = 0;

  while (true) {
    if (money < money_list[i]) {
      i++;
    } else if (money > money_list[i]) {
      result[i]++;
      money -= money_list[i];
    } else if (money === money_list[i]) {
      result[i]++;
      money -= money_list[i];
      break;
    }
  }

  return result;
};

console.log(solution(money2));
