// test1
var x1 = 23;
// test2
var x2 = 32;
// test3
var x3 = 64;
// test4
var x4 = 48;
// test5
var x5 = 57;

function solution (x) {

    var temp = x.toString(2).split('');
    var answer = temp.filter((v) => { return v === '1'});
    return answer.length;
}

console.log(solution(x5));