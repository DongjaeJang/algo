// const solution = (name) => {
//   const alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//   const alen = alphabet.length;
//   const mid = alen / 2;
//   let answer = 0;
//   let targetName = [];
//   for (let i = 0; i < name.length; i++) targetName.push("A");
//   let start = 0;
//   while (targetName.join("") !== name) {
//     if (targetName[start] !== name[start]) {
//       let target = name[start];
//       let targetIdx = alphabet.split("").indexOf(target);
//       let up = targetIdx;
//       if (up < mid) {
//         answer += up;
//       } else {
//         answer += alen - up;
//       }
//       targetName[start] = target;
//     } else {
//       // 현재 인덱스 기준 왼쪽, 오른쪽 문자열
//       let leftTargetName = targetName.slice(0, start);
//       let rightTargetName = targetName.slice(start + 1);
//       // 현재 인덱스 기준 오른쪽으로 순서대로 읽었을 때
//       let tempTargetNameR = rightTargetName.concat(leftTargetName);
//       // 현재 인덱스 기준 왼쪽으로 순서대로 읽었을 때
//       let tempTargetNameL = leftTargetName
//         .reverse()
//         .concat(rightTargetName.reverse());
//       let leftName = name.slice(0, start);
//       let rightName = name.slice(start + 1);
//       let tempNameR = rightName + leftName;
//       let tempNameL =
//         leftName.split("").reverse().join("") +
//         rightName.split("").reverse().join("");
//       let rightSum = 0;
//       let right = [];
//       tempTargetNameR.forEach((letter, index) => {
//         if (letter !== tempNameR[index]) right.push(index + 1);
//       });
//       let leftSum = 0;
//       let left = [];
//       tempTargetNameL.forEach((letter, index) => {
//         if (letter !== tempNameL[index]) left.push(index + 1);
//       });
//       let tempLeft = [];
//       let tempRight = [];
//       tempLeft.push(left[0]);
//       tempRight.push(right[0]);
//       for (let j = 0; j < left.length - 1; j++)
//         tempLeft.push(left[j + 1] - left[j]);
//       for (let j = 0; j < right.length - 1; j++)
//         tempRight.push(right[j + 1] - right[j]);
//       for (let j = 0; j < tempLeft.length; j++) {
//         if (j < tempLeft.length - 1) {
//           if (tempLeft[j] === tempRight[j]) {
//             if (tempLeft[j + 1] === tempRight[j + 1]) continue;
//             else if (tempLeft[j + 1] < tempRight[j + 1]) {
//               rightSum = 2;
//               leftSum = 1;
//             } else {
//               rightSum = 1;
//               leftSum = 2;
//             }
//           } else if (tempLeft[j] > tempRight[j]) {
//             rightSum = 1;
//             leftSum = 2;
//           } else {
//             rightSum = 2;
//             leftSum = 1;
//           }
//         } else {
//           if (tempLeft[j] >= tempRight[j]) {
//             rightSum = 1;
//             leftSum = 2;
//           } else {
//             rightSum = 2;
//             leftSum = 1;
//           }
//         }
//       }
//       console.log(`tempRight : ${tempRight}, tempLeft : ${tempLeft}`);
//       // 오른쪽으로 진행
//       if (rightSum < leftSum) {
//         for (let i = 0; i < tempTargetNameR.length; i++) {
//           if (tempTargetNameR[i] !== tempNameR[i]) {
//             start += i + 1;
//             if (start >= name.length) start -= name.length;
//             answer += i + 1;
//             break;
//           }
//         }
//       } else {
//         for (let i = 0; i < tempTargetNameL.length; i++) {
//           if (tempTargetNameL[i] !== tempNameL[i]) {
//             start -= i + 1;
//             if (start < 0) start += name.length;
//             answer += i + 1;
//             break;
//           }
//         }
//       }
//     }
//   }
//   return answer;
// };

// 틀린 코드 ===> 오른쪽으로 갈지 왼쪽으로 갈지를 다시 정해줘야됨. 윗 코드로 시도하다가 안됨.
const solution = (name) => {
  const alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  const alen = alphabet.length;
  const mid = alen / 2;
  let answer = 0;
  let targetName = [];
  for (let i = 0; i < name.length; i++) targetName.push("A");
  let start = 0;
  while (targetName.join("") !== name) {
    if (targetName[start] !== name[start]) {
      let target = name[start];
      let targetIdx = alphabet.split("").indexOf(target);
      let up = targetIdx;
      if (up < mid) {
        answer += up;
      } else {
        answer += alen - up;
      }
      targetName[start] = target;
    } else {
      // 현재 인덱스 기준 왼쪽, 오른쪽 문자열
      let leftTargetName = targetName.slice(0, start);
      let rightTargetName = targetName.slice(start + 1);
      // 현재 인덱스 기준 오른쪽으로 순서대로 읽었을 때
      let tempTargetNameR = rightTargetName.concat(leftTargetName);
      // 현재 인덱스 기준 왼쪽으로 순서대로 읽었을 때
      let tempTargetNameL = leftTargetName
        .reverse()
        .concat(rightTargetName.reverse());
      let leftName = name.slice(0, start);
      let rightName = name.slice(start + 1);
      let tempNameR = rightName + leftName;
      let tempNameL =
        leftName.split("").reverse().join("") +
        rightName.split("").reverse().join("");
      let rightSum = 0;
      let right = [];
      tempTargetNameR.forEach((letter, index) => {
        if (letter !== tempNameR[index]) right.push(index + 1);
      });
      if (right.length === 1) rightSum += right[0];
      else {
        for (let j = 0; j < right.length - 1; j++) {
          rightSum += right[j + 1] - right[j];
        }
      }
      let leftSum = 0;
      let left = [];
      tempTargetNameL.forEach((letter, index) => {
        if (letter !== tempNameL[index]) left.push(index + 1);
      });
      if (left.length === 1) leftSum += left[0];
      else {
        for (let j = 0; j < left.length - 1; j++) {
          leftSum += left[j + 1] - left[j];
        }
      }
      // 오른쪽으로 진행
      if (rightSum < leftSum) {
        for (let i = 0; i < tempTargetNameR.length; i++) {
          if (tempTargetNameR[i] !== tempNameR[i]) {
            start += i + 1;
            if (start >= name.length) start -= name.length;
            answer += i + 1;
            break;
          }
        }
      } else {
        for (let i = 0; i < tempTargetNameL.length; i++) {
          if (tempTargetNameL[i] !== tempNameL[i]) {
            start -= i + 1;
            if (start < 0) start += name.length;
            answer += i + 1;
            break;
          }
        }
      }
    }
  }
  return answer;
};

console.log(solution("BBBBAAAAB"));
