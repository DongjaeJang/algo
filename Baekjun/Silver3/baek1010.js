//test1
var n1 = 2;
var m1 = 2;
//test2
var n2 = 1;
var m2 = 5;
//test3
var n3 = 13;
var m3 = 29;


function solution(n, m) {
    var west = n;
    var east = m;

    var westP = 1;
    var eastP = 1;

    for (var i = 1; i <= west; i++)
        westP *= i;
    for (var i = 0; i < west; i++)
    {
        eastP *= east;
        east--;
    }
    var answer = parseInt(eastP / westP);

    return answer;
}

console.log(solution(n2,m2));