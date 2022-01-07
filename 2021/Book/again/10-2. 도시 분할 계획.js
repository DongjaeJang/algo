const n = 7;
const info = [
  [1, 2, 3],
  [1, 3, 2],
  [3, 2, 1],
  [2, 5, 2],
  [3, 4, 4],
  [7, 3, 6],
  [5, 1, 5],
  [1, 6, 2],
  [6, 4, 1],
  [6, 5, 3],
  [4, 5, 3],
  [6, 7, 4],
];

function solution(n, info) {
  // 루트 노드를 담을 배열 parent
  const parent = Array(n + 1).fill(0);
  // 자기 자신으로 초기화
  for (let i = 1; i < n + 1; i++) parent[i] = i;
  // 간선 정보들을 담을 배열 edges와 최소 비용 간선을 담을 result
  const edges = [];
  const result = [];
  // 간선 정보를 graph에 추가
  info.forEach((information) => {
    const [a, b, cost] = information;
    // 시작 노드에 cost, b 순으로 추가
    edges.push({ start: a, next: b, cost: cost });
  });
  // 비용이 적은 것부터 선택해야하기 때문에 cost로 오름차순 정렬한다.
  edges.sort((a, b) => a.cost - b.cost);
  // 간선 갯수만큼 확인하면서 돈다.
  for (let i = 0; i < edges.length; i++) {
    // 현재 edge => current ( start, next, cost ) 를 담고 있다.
    const current = edges[i];
    // 루트 노드가 다르다면 연결 진행
    if (
      find_parent(parent, current.start) !== find_parent(parent, current.next)
    ) {
      union_parent(parent, current.start, current.next);
      result.push(current.cost);
    } else continue;
  }
  // 2개 도시로 분할을 위해 가장 큰 간선 제거
  result.pop();
  return result.reduce((acc, cur) => {
    return (acc += cur);
  }, 0);
}

// 루트노드 확인하는 함수
function find_parent(parent, x) {
  if (parent[x] !== x) parent[x] = find_parent(parent, parent[x]);
  return parent[x];
}

// 노드간 연결하고 루트노드를 통일하는 함수
function union_parent(parent, a, b) {
  // 무조건 루트값을 체인지 해줘야한다
  const rootA = find_parent(parent, a);
  const rootB = find_parent(parent, b);
  if (rootA < rootB) parent[rootB] = rootA;
  else parent[rootA] = rootB;
}

console.log(solution(n, info));
