const pb1 = ["119", "97674223", "1195524421"];
const pb2 = ["123", "456", "789"];
const pb3 = ["12", "123", "1235", "567", "88"];

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
