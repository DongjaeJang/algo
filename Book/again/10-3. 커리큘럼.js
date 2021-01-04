const n = 5;
const info = [
  [10, -1],
  [10, 1, -1],
  [4, 1, -1],
  [4, 3, 1, -1],
  [3, 3, -1],
];

function solution(n, info) {
  const indegree = Array(n + 1).fill(0);
  const graph = Array.from(Array(n + 1), () => Array(0));
  const time = Array(n + 1).fill(0);

  // graph에 간선정보 입력
  for (let i = 0; i < info.length; i++) {
    const currentInfo = info[i];
    for (let j = 0; j < currentInfo.length; j++) {
      const current = currentInfo[j];
      if (current === -1) break;
      else if (j === 0) {
        time[i + 1] = current;
      } else {
        graph[i + 1].push({ node: current, cost: time[current] });
        indegree[i + 1] += 1;
      }
    }
  }
  const result = [];
  // info 순서대로 출력
  for (let i = 1; i < n + 1; i++) {
    const currentIndegree = indegree[i];
    if (currentIndegree === 0) result.push(time[i]);
    else {
      let prevTime = 0;
      for (let j = 0; j < graph[i].length; j++) {
        const currentNode = graph[i][j];
        prevTime = Math.max(prevTime, time[currentNode.node]);
      }
      result.push(time[i] + prevTime);
      time[i] += prevTime;
    }
  }
  return result;
}

console.log(solution(n, info));
