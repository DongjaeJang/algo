const n = 5;
const info = [
  [11, -15, -15],
  [14, -5, -15],
  [-1, -1, -5],
  [10, -4, -1],
  [19, -4, 19],
];

function solution(n, info) {
  const parent = Array(n).fill(0);
  for (let i = 0; i < n; i++) parent[i] = i;
  const edges = [];
  const result = [];

  for (let i = 0; i < n - 1; i++) {
    for (let j = i + 1; j < n; j++) {
      edges.push({
        start: i,
        end: j,
        cost: Math.min(
          Math.abs(info[i][0] - info[j][0]),
          Math.abs(info[i][1] - info[j][1]),
          Math.abs(info[i][2] - info[j][2])
        ),
      });
    }
  }
  edges.sort((a, b) => a.cost - b.cost);

  for (let i = 0; i < edges.length; i++) {
    const { start, end, cost } = edges[i];
    if (find_parent(parent, start) !== find_parent(parent, end)) {
      result.push(cost);
      union_parent(parent, start, end);
    }
  }

  return result.reduce((acc, cur) => (acc += cur), 0);
}

function find_parent(parent, x) {
  if (parent[x] !== x) parent[x] = find_parent(parent, parent[x]);
  return parent[x];
}

function union_parent(parent, a, b) {
  const rootA = find_parent(parent, a);
  const rootB = find_parent(parent, b);
  if (rootA < rootB) parent[rootB] = rootA;
  else parent[rootA] = rootB;
}

console.log(solution(n, info));
