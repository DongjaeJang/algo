//test1
var n1 = 7;
var k1 = 3;
//test2
var n2 = 5;
var k2 = 2;

function solution (n, k) {
    var temp = [];
    var answer = [];

    for (var i = 0; i < n; i++)
        temp.push(i+1);

    var idx = 0;
    while (temp.length !== 0)
    {
        var cnt = 0;
        for (var i = idx; i <= temp.length; i++)
        {
            cnt++;
            if (i === temp.length)
                i = 0;
            if (cnt === k)
            {
                answer.push(temp[i]);
                idx = i;
                temp.splice(idx, 1);
                break;
            }
        }
    }

    return answer;
}

console.log(solution(n2, k2));