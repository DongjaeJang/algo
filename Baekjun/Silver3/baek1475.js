// 방번호

//test1
var test1 = "9999";
//test2
var test2 = "0153864559923";

function solution(t) {
    var temp = t.split('');
    var numberList = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
    temp.forEach((v) => {
        numberList[v] += 1;
    });
    var n9 = Number(numberList.splice(9,1));
    var n6 = Number(numberList.splice(6,1));
    var n69 = Math.ceil((n6 + n9) / 2);

    return Math.max.apply(null, numberList) >= n69 ? Math.max.apply(null, numberList) : n69;
}

console.log(solution(test2));