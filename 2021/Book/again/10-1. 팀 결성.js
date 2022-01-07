const { resultKeyNameFromField } = require("@apollo/client/utilities");

/**
 * 팀 합치기 : 0, 같은 팀 여부 확인 : 1
 */
const n = 7;
const info = [
  [0, 1, 3],
  [1, 1, 7],
  [0, 7, 6],
  [1, 7, 1],
  [0, 3, 7],
  [0, 4, 2],
  [0, 1, 1],
  [1, 1, 1],
];

function solution(n, info) {
  // 정답을 담을 배열
  const answer = [];
  // 루트 노드가 무엇인지 확인하기 위해 parent 배열 생성
  const parent = Array(n + 1).fill(0);
  // 처음엔 루트 노드가 자기 자신
  for (let i = 1; i < n + 1; i++) parent[i] = i;
  // 각 연산에 대해 함수 수행
  info.forEach((information) => {
    const [operation, a, b] = information;
    if (operation === 1) {
      if (find_parent(parent, a) === find_parent(parent, b)) answer.push("YES");
      else answer.push("NO");
    } else {
      union_parent(parent, a, b);
    }
  });

  console.log(parent);
  return answer;
}

// 루트 노드를 찾는 함수
function find_parent(parent, x) {
  if (parent[x] !== x) parent[x] = find_parent(parent, parent[x]);
  return parent[x];
}
// 루트 노드 합치는 함수
function union_parent(parent, a, b) {
  // a, b의 루트 찾기
  const rootA = find_parent(parent, a);
  const rootB = find_parent(parent, b);

  if (rootA < rootB) {
    parent[rootB] = rootA;
  } else {
    parent[rootA] = rootB;
  }
}

console.log(solution(n, info));
