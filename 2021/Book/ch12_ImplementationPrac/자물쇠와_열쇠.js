const key1 = [
  [0, 0, 0],
  [1, 0, 0],
  [0, 1, 1],
];
const lock1 = [
  [1, 1, 1],
  [1, 1, 0],
  [1, 0, 1],
];
function solution(key, lock) {
  const len = lock.length;
  const array = Array.from(Array(len * 3), () => Array(len * 3).fill(null));

  for (let i = len; i < len * 2; i++) {
    for (let j = len; j < len * 2; j++) array[i][j] = lock[i - len][j - len];
  }

  for (let i = 0; i < 4; i++) {
    key = i === 0 ? key : rotate90(key);
    for (let j = 0; j <= array.length - key.length; j++) {
      for (let k = 0; k <= array[0].length - key[0].length; k++) {
        const newlock = array.map(function (arr) {
          return arr.slice();
        });
        for (let m = 0; m < key.length; m++) {
          for (let n = 0; n < key.length; n++) {
            if (newlock[j + m][k + n] === 1 && key[m][n] === 1)
              newlock[j + m][k + n] = 2;
            else if (newlock[j + m][k + n] === 1 && key[m][n] === 0)
              newlock[j + m][k + n] = 1;
            else newlock[j + m][k + n] = key[m][n];
          }
        }
        if (isAnswer(newlock, len)) return true;
      }
    }
  }
  return false;
}

function isAnswer(newLock, len) {
  for (let i = len; i < len * 2; i++) {
    for (let j = len; j < len * 2; j++) {
      if (newLock[i][j] !== 1) return false;
    }
  }
  return true;
}

function rotate90(arr) {
  const len = arr.length;
  const result = Array.from(Array(len), () => Array(len).fill(null));
  for (let row = 0; row < len; row++) {
    for (let col = 0; col < len; col++) {
      result[col][len - 1 - row] = arr[row][col];
    }
  }
  return result;
}

console.log(solution(key1, lock1));
