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
// 진입 차수를 담을 배열. 원소는 모두 0으로 초기화
const indegree = Array(node + 1).fill(0);
// 간선 정보를 담을 그래프
const graph = Array.from(Array(node + 1), () => Array(0));
// 간선 정보 담기
info.forEach((information) => {
  const [a, b] = information;
  graph[a].push(b);
  indegree[b]++;
});
// 위상 정렬 함수
const topology_sort = () => {
  const result = [];
  const queue = [];
  // 처음에 indegree가 0인 노드를 모두 큐에 삽입
  for (let i = 1; i < node + 1; i++) if (indegree[i] === 0) queue.push(i);
  // 큐가 빌때까지 계속 진행
  while (queue.length > 0) {
    const current = queue.shift();
    result.push(current);
    for (let node of graph[current]) {
      indegree[node]--;
      // 새롭게 진입차수가 0이된 노드를 큐에 추가
      if (indegree[node] === 0) queue.push(node);
    }
  }
  console.log(result);
};

// 1 2 5 3 6 4 7
topology_sort();
