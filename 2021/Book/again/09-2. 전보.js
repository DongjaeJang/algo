const n = 3;
const c = 1;
const info = [
  [1, 2, 4],
  [1, 3, 2],
];

function solution(n, c, info) {
  const INF = 1e9;
  // 초기 배열 설정
  const graph = Array.from(Array(n + 1), () => Array(0));
  // 간선 정보 등록
  info.forEach((information) => {
    const [a, b, cost] = information;
    graph[a].push([cost, b]);
  });
  // 거리 정보 등록할 배열
  const distance = Array(n + 1).fill(INF);

  function dijkstra(start) {
    // 노드를 담을 배열 queue
    const queue = [];
    queue.push([0, start]);
    // 시작점 0으로 표시
    distance[start] = 0;
    // 연결된 부분 확인 queue가 비워질 때까지 계속 한다.
    while (queue.length > 0) {
      // 먼저 queue를 cost에 따라 정렬해주어야 한다.
      queue.sort((a, b) => a[0] - b[0]);
      // queue에서 뺀 노드
      const [currentCost, currentNode] = queue.shift();
      // 해당 노드에 연결되어있는 노드들을 체크한다.
      for (let i = 0; i < graph[currentNode].length; i++) {
        const [tempCost, tempNext] = graph[currentNode][i];
        distance[tempNext] = Math.min(
          distance[tempNext],
          tempCost + currentCost
        );
        queue.push([distance[tempNext], tempNext]);
      }
    }
  }
  dijkstra(c);
  // 결과를 담을 변수
  let count = 0;
  let time = 0;
  // distance를 순회하면서 INF와 0이 아닌 값들을 세서 count에 넣고, 그 중 가장 큰 값을 time에 넣는다.
  for (let i = 1; i < n + 1; i++) {
    if (distance[i] > 0 && distance[i] < INF) {
      count++;
      if (time < distance[i]) time = distance[i];
    }
  }
  return [count, time];
}

console.log(solution(n, c, info));
