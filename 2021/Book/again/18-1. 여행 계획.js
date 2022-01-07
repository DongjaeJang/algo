const n = 5;
const info = [
  [0, 1, 0, 1, 1],
  [1, 0, 1, 1, 0],
  [0, 1, 0, 0, 0],
  [1, 1, 0, 0, 0],
  [1, 0, 0, 0, 0],
];
const target = [2, 3, 4, 3];

function solution(n, info, target) {
  const parent = Array(n + 1).fill(0);
  for (let i = 1; i < n + 1; i++) parent[i] = i;
  const graph = Array.from(Array(n + 1), () => Array(0));

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (info[i][j] === 1) graph[i + 1].push(j + 1);
    }
  }
  for (let i = 1; i < n + 1; i++) {
    for (let j = 0; j < graph[i].length; j++)
      if (find_parent(parent, i) !== find_parent(parent, graph[i][j])) {
        union_parent(parent, i, graph[i][j]);
      }
  }

  const result = new Set();
  for (let i = 0; i < target.length; i++) {
    result.add(find_parent(parent, target[i]));
  }
  return result.size === 1 ? "YES" : "NO";
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

console.log(solution(n, info, target));
