//test1
var string1 = "25 7 5";
//test2
var string2 = "1 3 999999";


function solution(string) {

    var temp = string.split(" ");
    var a = Number(temp[0]);
    var b = Number(temp[1]);
    var n = Number(temp[2]);
    var c;
    var answer;
    while (n--) {
        a *= 10;
        c = a % b;
        answer = parseInt(a / b);
        a = c;
    }

    return answer;
    // while 문으로 변경해서 나누기 10씩 계속
}

console.log(solution(string1));