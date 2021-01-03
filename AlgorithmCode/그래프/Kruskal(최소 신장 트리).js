const node = 7;
const edge = 9;
const info = [
  [1, 2, 29],
  [1, 5, 75],
  [2, 3, 35],
  [2, 6, 34],
  [3, 4, 7],
  [4, 6, 23],
  [4, 7, 13],
  [5, 6, 53],
  [6, 7, 25],
];
/**
 * 최소 spanning tree 만드는 알고리즘 ==> Kruskal
 * O(ElogE)
 * 1. parent 배열 선언한 뒤, 자기 자신으로 향하게 초기화 시켜준다.
 * 2. find_parent와 union_parent 함수 두개를 만든다.
 */

const parent = Array(node + 1).fill(0);
for (let i = 1; i < node + 1; i++) parent[i] = i;

// 루트 노드를 찾는 함수
const find_parent = (parent, x) => {
  if (parent[x] !== x) parent[x] = find_parent(parent, parent[x]);
  return parent[x];
};

// 두 노드를 비교해서 합쳐준다.
const union_parent = (parent, a, b) => {
  a = find_parent(parent, a);
  b = find_parent(parent, b);

  if (a < b) parent[b] = a;
  else parent[a] = b;
};

// 간선 정보를 담을 edges 배열과 최소 결과를 담을 result 배열
const edges = [];
const result = [];

// 주어진 간선 정보 edges에 저장
info.forEach((information) => {
  const [start, end, cost] = information;
  edges.push({ cost: cost, start: start, end: end });
});

// cost 기준으로 오름차순 정렬
edges.sort((a, b) => a.cost - b.cost);

// 하나씩 순회하면서 찾는다
for (let node of edges) {
  const { cost, start, end } = node;
  // 그래프가 사이클을 만들지 않는다면 result에 추가한다.
  if (find_parent(parent, start) !== find_parent(parent, end)) {
    // 서로 연결해주고
    union_parent(parent, start, end);
    result.push(cost);
  }
}
// 159
console.log(result.reduce((acc, cur) => (acc += cur)));
