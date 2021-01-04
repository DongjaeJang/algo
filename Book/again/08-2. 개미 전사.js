/**
 * 다이나믹 프로그래밍은 점화식을 세우는게 중요하다.
 * 여기서는 바로 전 창고를 털면 다음 창고를 털지 못하므로, 현재 값과 두개 전 창고를 터는 것이 이득인지 바로 전 창고를 터는 게 이득인지 알아야한다.
 * 점화식 => Dn = max(Dn-1, Dn-2 + An)
 */

const n = 4;
const storage = [1, 3, 1, 5];

function solution(n, storage) {
  const array = Array(n);
  array[0] = storage[0];
  array[1] = Math.max(storage[0], storage[1]);

  for (let i = 2; i < n; i++) {
    array[i] = Math.max(array[i - 2] + storage[i], array[i - 1]);
  }

  console.log(array);
}

console.log(solution(n, storage));
