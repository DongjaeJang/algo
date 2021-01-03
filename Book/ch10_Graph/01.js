const n = 7;
const info = [
  [0, 1, 3],
  [1, 1, 7],
  [0, 7, 6],
  [1, 7, 1],
  [0, 3, 7],
  [0, 4, 2],
  [0, 1, 1],
  [1, 1, 1],
];

// 메세지 담을 배열
const result = [];
// 처음엔 n + 1 팀. 각자 root를 본인으로 설정
const parent = Array(n + 1);
for (let i = 0; i < n + 1; i++) parent[i] = i;

const find_parent = (parent, x) => {
  if (parent[x] !== x) parent[x] = find_parent(parent, parent[x]);
  return parent[x];
};

const union_parent = (parent, a, b) => {
  a = find_parent(parent, a);
  b = find_parent(parent, b);
  if (a < b) parent[b] = a;
  else parent[a] = b;
};

info.forEach((information) => {
  const [operation, a, b] = information;
  // 합치기 연산
  if (operation === 0) {
    union_parent(parent, a, b);
  } else {
    // 여부 확인
    if (find_parent(parent, a) === find_parent(parent, b)) result.push("YES");
    else result.push("NO");
  }
});

console.log(result);
