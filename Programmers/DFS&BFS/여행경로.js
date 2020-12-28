function solution(tickets) {
  let answer = [];
  let start = "ICN";
  dfs(tickets, start, answer);

  return answer.sort()[0];
}

function dfs(list, start, result, route = ["ICN"]) {
  if (list.length === 0) result.push(route);
  else {
    for (let i = 0; i < list.length; i++) {
      if (list[i][0] === start) {
        let cur = [...list];
        cur.splice(i, 1);
        dfs(cur, list[i][1], result, route.concat(list[i][1]));
      }
    }
  }
}

console.log(
  solution([
    ["ICN", "JFK"],
    ["HND", "IAD"],
    ["JFK", "HND"],
  ])
);
