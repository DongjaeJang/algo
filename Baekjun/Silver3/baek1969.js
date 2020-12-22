let test = "TATGATAC\nTAAGCTAC\nAAAGATCC\nTGAGATAC\nTAAGATGT";
let test2 = "ACGTACGTAC\nCCGTACGTAG\nGCGTACGTAT\nTCGTACGTAA";
let test3 =
  "ATGTTACCAT\nAAGTTACGAT\nAACAAAGCAA\nAAGTTACCTT\nAAGTTACCAA\nTACTTACCAA";

function solution(str) {
  let dna = "";
  let list = str.split("\n");
  let count = 0;

  for (let i = 0; i < list[0].length; i++) {
    // temp A C G T
    let temp = [0, 0, 0, 0];
    list.forEach((letter) => {
      let tl = letter[i];
      if (tl === "A") temp[0] += 1;
      else if (tl === "C") temp[1] += 1;
      else if (tl === "G") temp[2] += 1;
      else temp[3] += 1;
    });
    let max = Math.max.apply(null, temp);
    let sum = temp.reduce((acc, cur) => acc + cur) - max;
    for (let i = 0; i < 4; i++) {
      if (temp[i] === max) {
        switch (i) {
          case 0:
            dna += "A";
            break;
          case 1:
            dna += "C";
            break;
          case 2:
            dna += "G";
            break;
          case 3:
            dna += "T";
            break;
        }
        break;
      }
    }
    count += sum;
  }

  return dna + "\n" + count;
}

console.log(solution(test3));
