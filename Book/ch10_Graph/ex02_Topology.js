/**
 * 방향을 거스르지 않도록 순서대로 나열 ==> Topology
 * 진입 차수에 따라 출력한다고 생각하면 된다.
 * 시간 복잡도 == O(V+E)
 */
const node = 7;
const info = [
  [1, 2],
  [1, 5],
  [2, 3],
  [2, 6],
  [3, 4],
  [4, 7],
  [5, 6],
  [6, 4],
];
// 진입 차수를 나타내는 배열
const indegree = Array(node + 1).fill(0);
// 간선 정보를 담기 위한 배열 초기화
const graph = Array.from(Array(node + 1), () => Array(0));

// 간선 정보 담기
info.forEach((information) => {
  const [a, b] = information;
  graph[a].push(b);
  indegree[b]++;
});
// 위상 정렬 함수 (Topology)
function topology_sort() {
  const result = [];
  const queue = [];

  // 처음 시작하기 전에 진입 차수가 0인 노드들 모두 큐에 삽입
  for (let i = 1; i < indegree.length; i++) {
    if (indegree[i] === 0) queue.push(i);
  }
  // 큐가 빌때 까지 계속한다
  while (queue.length > 0) {
    const current = queue.shift();
    result.push(current);
    // 해당 원소와 연결된 노드들의 진입차수에서 1빼기
    for (let node of graph[current]) {
      indegree[node] -= 1;
      // 새롭게 진입차수가 0이되는 노드를 큐에 삽입
      if (indegree[node] === 0) queue.push(node);
    }
  }

  return result;
}
// 1 2 5 3 6 4 7
console.log(topology_sort());
