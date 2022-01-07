// test1
var test1 = "XXXXXX";
// test2
var test2 = "XX.XX";
// test3
var test3 = "XXXX....XXX.....XX";
// test4
var test4 = "X";
// test5
var test5 = "XX.XXXXXXXXXX..XXXXXXXX..XXXXXX";
// test6
var test6 = "XXX...X..XXXX";
// test7
var test7 = "XX...XXXX..XXXXXX";

function solution(test) {
    var A = "AAAA";
    var B = "BB";
    var error = 0;
    var answer = '';
    var tempString = '';

    test.split('').forEach((value,index) => {
        if (value === 'X')
        {
            tempString += 'X';
            if (tempString.length % 4 === 0)
            {
                tempString = '';
                answer += A;
            }
            else if (tempString.length % 4 === 2)
            {
                if (test[index+1] === '.' || test[index+1] === undefined)
                {
                    tempString = '';
                    answer += B;
                }
            }
            else if (tempString.length % 4 === 1 || tempString.length % 4 === 3)
            {
                if (test[index+1] === '.' || test[index+1] === undefined) {
                    error = -1;
                    tempString = '';
                }
            }
        }
        else
        {
            answer += '.';
            tempString = '';
        }
        
    });

    return error === 0 ? answer : error;
}

console.log(solution(test7));