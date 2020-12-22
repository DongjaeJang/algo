//test1
var lucky1 = [1, 7, 14, 10];
var N1 = 2;
//test2
var lucky2 = [2, 8, 6, 16, 3, 12, 7];
var N2 = 14;
//test3
var lucky3 = [1,8,7,2,15,5];
var N3 = 5;


function solution (lucky, N) {

    var tempLucky = lucky.sort((a,b) => {return a-b;});

    var maxTemp = tempLucky.filter((v) => { return v >= N; });
    var minTemp = tempLucky.filter((v) => { return v <= N; });

    var max = maxTemp[0];
    var min = minTemp[minTemp.length-1];

    if (max === N || min === N)
        return 0;

    return max - min - 2;
}

console.log(solution(lucky3, N3));