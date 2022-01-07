const n = 4,
  k = 2,
  x = 1;
const info = [
  [1, 2],
  [1, 3],
  [2, 3],
  [2, 4],
];

function solution(n, k, x, info) {
  const INF = 1e9;
  const distance = Array(n + 1).fill(INF);
  const graph = Array.from(Array(n + 1), () => Array(0));

  info.forEach((information) => {
    const [a, b] = information;
    graph[a].push(b);
  });

  dijkstra(x, distance, graph);

  const result = [];
  for (let i = 1; i < n + 1; i++) if (distance[i] === k) result.push(i);
  return result;
}

function dijkstra(start, distance, graph) {
  const queue = [];
  distance[start] = 0;
  queue.push([0, start]);

  while (queue.length > 0) {
    const [currentCost, currentNode] = queue.shift();
    for (let i = 0; i < graph[currentNode].length; i++) {
      const nextNode = graph[currentNode][i];
      distance[nextNode] = Math.min(distance[nextNode], currentCost + 1);
      queue.push([distance[nextNode], nextNode]);
    }
  }
}

console.log(solution(n, k, x, info));
