let ex1 = [
  [0, 0, 1, 1, 0],
  [0, 0, 0, 1, 1],
  [1, 1, 1, 1, 1],
  [0, 0, 0, 0, 0],
];

let ex2 = [
  [0, 0, 1],
  [0, 1, 0],
  [1, 0, 1],
];

const solution = (map) => {
  const dfs = (x, y) => {
    // 수용 범위를 벗어나면 바로 탈출
    if (x < 0 || y < 0 || x > map.length - 1 || y > map[0].length - 1)
      return false;

    // 특정 노드를 방문하고 연결된 모든 노드 방문
    if (map[x][y] === 0) {
      // 방문 처리
      map[x][y] = 1;
      // 상하좌우 모두 호출
      dfs(x - 1, y);
      dfs(x + 1, y);
      dfs(x, y - 1);
      dfs(x, y + 1);
      return true;
    }
    return false;
  };

  let result = 0;

  for (let n = 0; n < map.length; n++) {
    for (let m = 0; m < map[0].length; m++) {
      // 현재 위치에서 dfs 수행
      if (dfs(n, m) === true) result += 1;
    }
  }

  return result;
};

console.log(solution(ex1));
