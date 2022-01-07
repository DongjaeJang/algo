const findMax = (list) => {
  let max = -1;
  const len = list.length;
  for (let i = 0; i < len; i++) {
    if (max < list[i]) max = list[i];
  }
  return max;
};

const findHidx = (list, max) => {
  for (let i = max; i >= 0; i--) {
    let hlist = hfilter(list, i);
    if (hlist.length >= i) return i;
  }
};

const hfilter = (list, jogun) => {
  const result = [];
  for (let i = 0; i < list.length; i++) {
    const inyong = list[i];
    if (inyong >= jogun) result.push(inyong);
  }
  return result;
};

const solution = (citations) => {
  let clen = citations.length;
  let tempMax = findMax(citations);
  let max = clen > tempMax ? clen : tempMax;
  let hIdx = findHidx(citations, max);
  return hIdx;
};

console.log(solution([3, 0, 6, 1, 5]));
