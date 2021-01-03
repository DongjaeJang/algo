const n = 7;
const m = 12;
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

// 루트 찾기
function find_parent(parent, x) {
  if (parent[x] !== x) parent[x] = find_parent(parent, parent[x]);
  return parent[x];
}

// 루트 합치기
function union_parent(parent, a, b) {
  const ar = find_parent(parent, a);
  const br = find_parent(parent, b);

  if (ar < br) {
    parent[br] = ar;
  } else {
    parent[ar] = br;
  }
}

// 배열 선언 후 초기화
const parent = Array(n + 1).fill(0);
for (let i = 1; i < n + 1; i++) parent[i] = i;

// 엣지정보와 필요한 간선을 담을 배열
const edges = [];
const result = [];
// 엣지정보를 edges에 추가
info.forEach((information) => {
  const [start, end, cost] = information;
  edges.push({ cost: cost, start: start, end: end });
});
// 엣지를 비용 기준 오름차순으로 정렬
edges.sort((a, b) => a.cost - b.cost);

// 간선을 하나씩 확인
for (let edge of edges) {
  const { cost, start, end } = edge;
  // 사이클이 발생하지 않는 경우에만 집합에 포함
  if (find_parent(parent, start) !== find_parent(parent, end)) {
    union_parent(parent, start, end);
    result.push(cost);
  }
}

result.sort((a, b) => a - b);
result.pop();
const answer = result.reduce((acc, cur) => (acc += cur), 0);

console.log(answer);
