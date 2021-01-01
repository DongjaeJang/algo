const n1 = 4;
const k1 = 2;
const x1 = 1;
const info1 = [
  [1, 2],
  [1, 3],
  [2, 3],
  [2, 4],
];

const n2 = 4;
const k2 = 2;
const x2 = 1;
const info2 = [
  [1, 2],
  [1, 3],
  [1, 4],
];

const n3 = 4;
const k3 = 1;
const x3 = 1;
const info3 = [
  [1, 2],
  [1, 3],
  [2, 3],
  [2, 4],
];
/**
 * 모든 노드 간에 weight가 똑같다면, BFS를 이용하여 구한다.
 * ---- 내 풀이 ----
 */
const solution = (n, k, x, info) => {
  const board = Array.from(Array(n), () => Array(n).fill(0));
  info.forEach((v) => {
    board[v[0] - 1][v[1] - 1] = 1;
  });
  const distance = Array.from(Array(n).fill(987654321));

  bfs(board, x, distance);
  const answer = [];
  distance.forEach((v, i) => {
    if (v === k) answer.push(i + 1);
  });
  return answer.length === 0 ? [-1] : answer;
};

const bfs = (array, start, distance) => {
  const queue = [start - 1];
  distance[start - 1] = 0;
  while (queue.length > 0) {
    const current = queue.shift();
    for (let i = 0; i < array.length; i++) {
      if (array[current][i] !== 0) {
        queue.push(i);
        distance[i] = Math.min(distance[current] + 1, distance[i]);
      }
    }
  }
};

console.log(solution(n3, k3, x3, info3));

/**
 * ---- 책 풀이 ----
 */
const solution2 = (n, k, x, info) => {
  const graph = Array.from(Array(n + 1), () => Array(0));
  for (let i = 0; i < info.length; i++) {
    const current = info[i];
    graph[current[0]].push(current[1]);
  }
  // 모든 도시에 대한 최단 거리 초기화
  const distance = Array.from(Array(n + 1).fill(-1));
  distance[x] = 0; // 출발 도시 = 0

  // bfs 수행
  const queue = [x];
  while (queue.length > 0) {
    const now = queue.shift();
    // 이동할 수 있는 도시 확인
    for (let next of graph[now]) {
      // 아직 방문하지 않았다면
      if (distance[next] === -1) {
        // 최단 거리 갱신
        distance[next] = distance[now] + 1;
        queue.push(next);
      }
    }
  }
  const answer = [];
  let check = false;
  for (let i = 1; i <= n; i++) {
    if (distance[i] === k) {
      answer.push(i);
      check = true;
    }
  }

  return check ? answer : [-1];
};

console.log(solution2(n3, k3, x3, info3));
