const card1 = [10, 20, 40];
const card2 = [10, 20, 30, 40];
const card3 = [10, 20, 40, 50];

const solution = (card) => {
  const sortedCard = card.slice();
  return findMin(sortedCard);
};

const findMin = (card) => {
  let sum = 0;
  while (true) {
    card.sort((a, b) => a - b);
    const first = card.shift();
    const second = card.shift();
    const temp = first + second;
    sum += temp;
    if (card.length === 0) {
      break;
    }
    card.push(temp);
  }
  return sum;
};

console.log(solution(card3));
