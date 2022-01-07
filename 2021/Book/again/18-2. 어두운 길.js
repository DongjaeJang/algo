const n = 7;
const info = [
  [0, 1, 7],
  [0, 3, 5],
  [1, 2, 8],
  [1, 3, 9],
  [1, 4, 7],
  [2, 4, 5],
  [3, 4, 15],
  [3, 5, 6],
  [4, 5, 8],
  [4, 6, 9],
  [5, 6, 11],
];

function solution(n, info) {
  const parent = Array(n).fill(0);
  for (let i = 0; i < n; i++) parent[i] = i;
  const edges = [];
  const result = [];
  info.forEach((information) => {
    const [a, b, cost] = information;
    edges.push({ start: a, end: b, cost: cost });
  });
  edges.sort((a, b) => a.cost - b.cost);
  const total = edges.map((v) => v.cost).reduce((acc, cur) => (acc += cur), 0);
  for (let i = 0; i < edges.length; i++) {
    const { start, end, cost } = edges[i];
    if (find_parent(parent, start) !== find_parent(parent, end)) {
      result.push(cost);
      union_parent(parent, start, end);
    }
  }
  const least = result.reduce((acc, cur) => (acc += cur), 0);
  return total - least;
}

function find_parent(parent, x) {
  if (parent[x] !== x) parent[x] = find_parent(parent, parent[x]);
  return parent[x];
}

function union_parent(parent, a, b) {
  const rootA = find_parent(parent, a);
  const rootB = find_parent(parent, b);

  if (rootA < rootB) parent[rootB] = rootA;
  else parent[rootB] = rootA;
}

console.log(solution(n, info));
