const array = [
  [0, 0, 0],
  [1, 0, 0],
  [0, 1, 1],
];
/**
 * N x N 행렬의 90도 회전
 * 회전 후의 행은 회전 전의 열 번호와 일치한다.
 * 회전 후의 열은 N-1 에서 회전 전의 행을 뺀 값과 같다.
 * ==> newArray[col][N-1-row] = array[row][col];
 */
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

/**
 * N x N 행렬의 180도 회전
 * 1. 마지막 인덱스(N-1) - 기존 배열의 행(row)은 새로운 배열의 행(row)이 된다.
 * 2. 마지막 인덱스(N-1) - 기존 배열의 열(col)은 새로운 배열의 열(col)이 된다.
 * ==> newArray[N-1-row][N-1-col] = array[row][col];
 */
function rotate180(arr) {
  const len = arr.length;
  const result = Array.from(Array(len), () => Array(len).fill(null));

  for (let row = 0; row < len; row++) {
    for (let col = 0; col < len; col++) {
      result[len - 1 - row][len - 1 - col] = arr[row][col];
    }
  }

  return result;
}

/**
 * N x N 행렬의 270도 회전
 * 회전 후의 열은 회전 전의 행과 일치한다.
 * 회전 후의 행은 N-1 에서 전의 열 번호를 뺀 값과 같다.
 * ==> newArray[N-1-col][row] = array[row][col];
 */
function rotate270(arr) {
  const len = arr.length;
  const result = Array.from(Array(len), () => Array(len).fill(null));

  for (let row = 0; row < len; row++) {
    for (let col = 0; col < len; col++) {
      result[len - 1 - col][row] = arr[row][col];
    }
  }

  return result;
}
