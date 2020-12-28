const array = [];

// 배열 초기화
const initialArray = (array) => {
  for (let i = 0; i <= 1000; i++) {
    array.push(0);
  }
};

const dp = (array, N) => {
  array[1] = 1;
  array[2] = 3;
  for (let i = 3; i <= N; i++) {
    array[i] = (array[i - 1] + array[i - 2] * 2) % 796796;
  }
  return array[N];
};
initialArray(array);
console.log(dp(array, 3));
