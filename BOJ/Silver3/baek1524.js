// 세준세비

// test1
var n1 = 2;
var test1 = "1 1\n1\n1\n3 2\n1 3 2\n5 5";


function solution (n, test) {

    var joon = [];
    var bi = [];
    test.split('\n').forEach((v, i) => {
        if (i % 3 === 1)
            joon.push(v.split(' ').sort((a,b) => { return a - b; }));
        else if (i % 3 === 2)
            bi.push(v.split(' ').sort((a,b) => { return a - b; }));
    });

    var answer = "";
    for (var i = 0; i < n; i++)
    {
        for (;;)
        {
            if (joon[i].length === 0 && bi[i].length === 0)
            {
                if (i === 0)
                    answer += 'C';
                else
                    answer += '\nC';
                break;
            }
            else if (joon[i].length === 0)
            {
                if (i === 0)
                    answer += 'B';
                else
                    answer += '\nB';
                break;
            }
            else if (bi[i].length === 0)
            {
                if (i === 0)
                    answer += 'S';
                else
                    answer += '\nS';
                break;
            }

            if (joon[i][0] >= bi[i][0])
                bi[i].splice(0,1);
            else if (bi[i][0] > joon[i][0])
                joon[i].splice(0,1);
        }
    }

    return answer;
}

console.log(solution(n1, test1))