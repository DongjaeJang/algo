// test1
var test1 = 2143;
// test2
var test2 = 8616513168465161548;

function solution(test) {
    return Number(String(test).split('').sort((a,b) => {return b-a;}).join(''));
}

console.log(solution(test2));