// @origin = answerList
// @compare = users' answerList
const answerCount = (origin, compare) => {
  let result = 0;
  const olen = origin.length;
  const clen = compare.length;

  for (let i = 0; i < olen; i++)
    if (origin[i] === compare[i % clen]) result += 1;

  return result;
};

const findMax = (_1, _2, _3) => {
  let max = -1;
  if (_1 > max) max = _1;
  if (_2 > max) max = _2;
  if (_3 > max) max = _3;

  return max;
};

const solution = (answers) => {
  const answer = [];

  const _1 = [1, 2, 3, 4, 5];
  const _2 = [2, 1, 2, 3, 2, 4, 2, 5];
  const _3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];

  const count_1 = answerCount(answers, _1);
  const count_2 = answerCount(answers, _2);
  const count_3 = answerCount(answers, _3);

  const max = findMax(count_1, count_2, count_3);

  if (count_1 === max) answer.push(1);
  if (count_2 === max) answer.push(2);
  if (count_3 === max) answer.push(3);

  return answer;
};

console.log(solution([1, 2, 3, 4, 5]));
