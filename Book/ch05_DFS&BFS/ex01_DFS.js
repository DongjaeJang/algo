/**
 * 방문 노드를 표시할 visited 배열 필요
 * 가장 깊은 노드부터 방문한다.
 * 재귀함수를 이용
 */
const dfs = (graph, v, visited, result) => {
  // 현재 노드 방문처리
  visited[v] = true;
  console.log(v);
  result.push(v);

  // 현재 노드와 연결된 다른 노드를 재귀적으로 방문. (visited가 false 일때만)
  /**
   * graph[v] => 현재 노드에 연결된 다른 노드. 만약 v가 1 이면 graph[1]의 값인 2, 3, 8을 차례로 방문하는 것이다.
   * => (adjacent로 표현)
   * graph[v][i]에서 i를 통해 2, 3, 8을 차례로 들여다본다. 여기서 방문하지 않은 곳을 먼저 방문
   * => (adjacent[i]로 표현)
   */
  const adjacent = graph[v];
  for (let i = 0; i < adjacent.length; i++) {
    if (!visited[adjacent[i]]) {
      dfs(graph, adjacent[i], visited, result);
    }
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
  let result = [];
  dfs(graph, 1, visited, result);

  return result;
};

console.log(solution());
