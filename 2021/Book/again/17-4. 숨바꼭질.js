const n = 6;
const info = [
  [3, 6],
  [4, 3],
  [3, 2],
  [1, 3],
  [1, 2],
  [2, 4],
  [5, 2],
];

function solution(n, info) {
  const INF = 1e9;
  const distance = Array(n + 1).fill(INF);
  const graph = Array.from(Array(n + 1), () => Array(0));

  info.forEach((information) => {
    const [a, b] = information;
    graph[a].push([1, b]);
    graph[b].push([1, a]);
  });
  dijkstra(1, graph, distance);
  const max = Math.max.apply(null, distance.slice(1));
  const idx = distance.indexOf(max);
  const num = distance.filter((v) => v === max).length;
  return [idx, max, num];
}

function dijkstra(start, graph, distance) {
  const len = graph.length;
  const queue = [];
  distance[start] = 0;
  queue.push([0, start]);

  while (queue.length > 0) {
    queue.sort((a, b) => a[0] - b[0]);
    const [currentCost, currentNode] = queue.shift();
    if (distance[currentNode] < currentCost) continue;

    for (let i = 0; i < graph[currentNode].length; i++) {
      const nextNode = graph[currentNode][i];
      const cost = currentCost + nextNode[0];
      if (cost < distance[nextNode[1]]) {
        distance[nextNode[1]] = cost;
        queue.push([cost, nextNode[1]]);
      }
    }
  }
}

console.log(solution(n, info));
