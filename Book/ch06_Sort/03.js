let arr1 = [1, 2, 5, 4, 3];
let arr2 = [5, 5, 6, 6, 5];
let k = 3;

const solution = (arr1, arr2, k) => {
  for (let i = 0; i < k; i++) {
    arr1.sort((a, b) => a - b);
    arr2.sort((a, b) => b - a);
    let tempA = arr1.shift();
    let tempB = arr2.shift();
    arr1.push(tempB);
    arr2.push(tempA);
  }
  return arr1.reduce((acc, cur) => {
    return (acc += cur);
  }, 0);
};

console.log(solution(arr1, arr2, k));
