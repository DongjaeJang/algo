const pb1 = ["119", "97674223", "1195524421"];
const pb2 = ["123", "456", "789"];
const pb3 = ["12", "123", "1235", "567", "88"];

// 1. 길이 별로 정렬한다.
// 2. 길이 순으로 돌기때문에 current의 뒤쪽만 확인하면 된다. (뒤는 current보다 길이가 짧거나 같으므로)
// 3. 뒤쪽의 값에 current의 길이만큼만 slice해서 같은지 비교하면 됨.
const solution = (pb) => {
  // phone_book 정렬
  pb.sort((a, b) => {
    if (a.length === b.length) {
      return a > b ? 1 : -1;
    }
    return a.length - b.length;
  });
  for (let i = 0; i < pb.length - 1; i++) {
    let current = pb[i];
    for (let j = i + 1; j < pb.length; j++) {
      let compare = pb[j].slice(0, current.length);
      if (current === compare) return false;
    }
  }
  return true;
};

console.log(solution(pb3));
