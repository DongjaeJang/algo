const stu1 = [
  "Junkyu 50 60 100",
  "Sangkeun 80 60 50",
  "Sunyoung 80 70 100",
  "Soong 50 60 90",
  "Haebin 50 60 100",
  "Kangsoo 60 80 100",
  "Donghyuk 80 60 100",
  "Sei 70 70 70",
  "Wonseob 70 70 90",
  "Sanghyun 70 70 80",
  "nsj 80 80 80",
  "Taewhan 50 60 90",
];

function solution(student) {
  return student
    .map((v) => {
      const [name, kor, eng, math] = v.split(" ");
      return { name: name, kor: kor, eng: eng, math: math };
    })
    .sort((a, b) => {
      if (a.kor === b.kor) {
        if (a.eng === b.eng) {
          if (a.math === b.math) return a.name > b.name ? 1 : -1;
          return b.math - a.math;
        }
        return a.eng - b.eng;
      }
      return b.kor - a.kor;
    })
    .map((v) => v.name);
}

console.log(solution(stu1));
