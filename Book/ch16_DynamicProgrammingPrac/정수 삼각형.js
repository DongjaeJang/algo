const n1 = 5;
const list1 = [7, 3, 8, 8, 1, 0, 2, 7, 4, 4, 4, 5, 2, 6, 5];
/**
 * 다이나믹 프로그래밍을 할 때,
 * 1. 기존 값을 가지고 있는 배열과
 * 2. 변화하는 값을 저장할 배열이 필요하다.
 */
const solution = (n, list) => {
  const list_ = list.slice();
  const tri = [];
  for (let i = 0; i < n; i++) {
    const temp = list_.splice(0, i + 1);
    tri.push(temp);
  }
  // 시작 값은 기존 배열과 동일
  const dynamicTri = tri.map((v) => v.slice());

  // 두번째 줄부터 합산을 진행한다.
  for (let row = 1; row < n; row++) {
    for (let col = 0; col <= row; col++) {
      // 첫번째 열인 경우에는 첫번째 열과 합산밖에 안됨
      if (col === 0)
        dynamicTri[row][col] = dynamicTri[row - 1][col] + tri[row][col];
      // 마지막 열인 경우에는 마지막 열과 합산밖에 안됨
      else if (col === row)
        dynamicTri[row][col] = dynamicTri[row - 1][col - 1] + tri[row][col];
      // 그 외에는 col-1과 col을 비교해준다.
      else
        dynamicTri[row][col] =
          Math.max(dynamicTri[row - 1][col - 1], dynamicTri[row - 1][col]) +
          tri[row][col];
    }
  }

  // 마지막 줄의 최댓값 출력
  return Math.max.apply(null, dynamicTri[n - 1]);
};

console.log(solution(n1, list1));
