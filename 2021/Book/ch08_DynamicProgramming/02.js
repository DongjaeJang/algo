const storage = [1, 3, 1, 5];
const array = [];

// 배열 초기화
const initialArray = (array) => {
  for (let i = 0; i <= 100; i++) {
    array.push(0);
  }
};
// 어떤게 더 나은선택인지 확인하면서 진행
// 점화식 => a(i) = max( a(i-1), a(i-2) + storage(i) )
const dp = (array, n) => {
  array[0] = storage[0];
  array[1] = Math.max(storage[0], storage[1]);

  for (let i = 2; i <= n; i++) {
    array[i] = Math.max(array[i - 1], array[i - 2] + storage[i]);
  }
  return array[n - 1];
};

initialArray(array);
console.log(dp(array, storage.length));
