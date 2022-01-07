/**
 * 성적이 낮은 순서대로 이름 출력하기
 */
const info = [
  ["홍길동", 95],
  ["이순신", 77],
];

function solution(info) {
  return info.sort((a, b) => a[1] - b[1]).map((v) => v[0]);
}

console.log(solution(info));
