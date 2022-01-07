const n1 = 3;
const c1 = 1;
const info1 = [
  [1, 2, 4],
  [1, 3, 2],
];

/**
 * 플로이드 워셜로도 풀 수 있지만, 노드의 갯수가 30000개이므로 다익스트라를 이용하는게 좋다.
 */
function solution(n, c, info) {
  const INF = 987654321;
  const graph = Array.from(Array(n + 1), () => Array(n + 1).fill(INF));
  // 자신 노드는 0
  for (let i = 1; i < n + 1; i++) {
    for (let j = 1; j < n + 1; j++) {
      if (i === j) graph[i][j] = 0;
    }
  }
  // 정보로 배열 업데이트
  info.forEach((information) => {
    const [start, end, weight] = information;
    graph[start][end] = weight;
  });

  // 플로이드 워셜 진행
  for (let k = 1; k < n + 1; k++) {
    for (let i = 1; i < n + 1; i++) {
      for (let j = 1; j < n + 1; j++) {
        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
      }
    }
  }
  let count = 0;
  let max = -1;
  for (let i = 1; i < n + 1; i++) {
    for (let j = 1; j < n + 1; j++) {
      if (graph[i][j] < INF && graph[i][j] > 0) {
        count++;
        if (max < graph[i][j]) max = graph[i][j];
      }
    }
  }
  return [count, max];
}

/**
 * 다익스트라 이용
 */
function solution2(n, c, info) {
  const INF = 987654321;
  const graph = Array.from(Array(n + 1), () => Array(0));
  const distance = Array(n + 1).fill(INF);

  // 간선 정보 입력
  info.forEach((v) => {
    const [start, end, weight] = v;
    graph[start].push([end, weight]);
  });

  function dijkstra(start) {
    const queue = [];
    queue.push([0, start]);
    distance[start] = 0;

    while (queue.length > 0) {
      // 거리가 짧은 것을 먼저 빼야하기 때문에 sort 해주어야함.
      queue.sort((a, b) => a[1] - b[1]);
      const [dist, now] = queue.shift();
      if (distance[now] < dist) continue;

      for (let i of graph[now]) {
        const cost = dist + i[1];

        if (cost < distance[i[0]]) {
          distance[i[0]] = cost;
          queue.push([cost, i[0]]);
        }
      }
    }
  }
  dijkstra(c);

  let count = 0;
  let max = -1;

  for (let i = 1; i < n + 1; i++) {
    if (distance[i] < INF && distance[i] > 0) {
      count++;
      max = Math.max(max, distance[i]);
    }
  }

  return [count, max];
}

console.log(solution2(n1, c1, info1));
