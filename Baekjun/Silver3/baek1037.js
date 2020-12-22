// test1
var num1 = 2;
var numList1 = [4, 2];
// test2
var num2 = 4;
var numList2 = [2, 4, 8, 16];
// test3
var num3 = 8;
var numList3 = [14, 16, 7, 8, 2, 4, 28, 56];


function solution (num, numList) {

    var answer;
    var n = num;
    var tempList = numList.sort((a,b) => {return a-b;});

    console.log(numList);

    answer = tempList[0] * tempList[n-1];

    return answer;
}

console.log(solution(num3, numList3));