// 날짜 계산

// test1
var test1 = "1 16 16";
// test2
var test2 = "1 1 1";
// test3
var test3 = "1 2 3";
// test4
var test4 = "15 28 19";


function solution(s) {
    var tempYear = [];
    s.split(' ').forEach(v => { tempYear.push(Number(v))});
    var temp = [1, 1, 1];
    var year = 1;

    for (;;)
    {
        if ((temp[0] === tempYear[0]) && (temp[1] === tempYear[1]) && (temp[2] === tempYear[2]))
            break;

        temp[0] += 1;
        temp[1] += 1;
        temp[2] += 1;
        year += 1;

        if (temp[0] === 16)
            temp[0] = 1;
        if (temp[1] === 29)
            temp[1] = 1;
        if (temp[2] === 20)
            temp[2] = 1;
    }

    return year;
}

console.log(solution(test4));