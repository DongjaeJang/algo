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
 * 최소 spanning tree 만드는 알고리즘 ==> 크루스칼
 * O(ElogE)
 */

// 특정원소가 속한 집합 찾기
function find_parent(parent, x) {
  if (parent[x] !== x) parent[x] = find_parent(parent, parent[x]);
  return parent[x];
}

// 두 원소가 속한 집합 합치기
function union_parent(parent, a, b) {
  a = find_parent(parent, a);
  b = find_parent(parent, b);
  if (a < b) {
    parent[b] = a;
  } else {
    parent[a] = b;
  }
}

// 부모 선언 후 자기 자신으로 초기화
const parent = Array(node + 1).fill(0);
for (let i = 1; i < node + 1; i++) parent[i] = i;

// 결과를 담을 변수 추가
const edges = [];
let result = 0;

// edges에 정보 추가
info.forEach((information) => {
  const [start, end, weight] = information;
  edges.push({ cost: weight, start: start, end: end });
});

// cost별로 정렬
edges.sort((a, b) => a.cost - b.cost);

// 간선을 하나씩 확인
for (let edge of edges) {
  const { cost, start, end } = edge;
  // 사이클이 발생하지 않는 경우에만 집합에 포함
  if (find_parent(parent, start) !== find_parent(parent, end)) {
    union_parent(parent, start, end);
    result += cost;
  }
}

console.log(edges.map((v) => v.cost));
console.log(result);
