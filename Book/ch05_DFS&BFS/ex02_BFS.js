/**
 * 방문 노드를 표시할 visited 필요
 * queue 사용
 * 인접 노드 중 방문하지 않은 노드를 모두 큐에 넣는다.
 */
const bfs = (graph, start, visited, result) => {
  // 큐 사용
  const queue = [start];
  // 현재 노드 방문 처리
  visited[start] = true;
  // 큐가 비워질때까지 반복
  // ---> 파이썬처럼 while문 조건으로 queue를 그대로 넣으면 오류가 뜬다. 조건을 true로 하고, 탈출조건문을 내부에 적어주는 것이 좋다.
  while (true) {
    const v = queue.shift();
    result.push(v);
    console.log(v);

    const adjacent = graph[v];
    for (let i = 0; i < adjacent.length; i++) {
      if (!visited[adjacent[i]]) {
        queue.push(adjacent[i]);
        visited[adjacent[i]] = true;
      }
    }

    if (queue.length === 0) break;
  }
};

const solution = () => {
  const graph = [
    [],
    [2, 3, 8],
    [1, 7],
    [1, 4, 5],
    [3, 5],
    [3, 4],
    [7],
    [2, 6, 8],
    [1, 7],
  ];
  let visited = [];
  for (let i = 0; i <= graph.length; i++) {
    visited.push(false);
  }
  let result = [];
  bfs(graph, 1, visited, result);

  return result;
};

console.log(solution());
