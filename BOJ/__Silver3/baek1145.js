// test1
var test1 = [30, 42, 70, 35, 90];
// test2
var test2 = [3, 82, 77, 90, 63];

function solution (n) {
    var temp = n;
    var num = 1;
    var size = 100*99*98;

    while (num <= size)
    {
        var cnt = 0;
        for (var i = 0; i < 5; i++)
        {
            if (n % temp[i] === 0)
                cnt += 1;
        }

        if (cnt >= 3)
            break;
        
        num += 1;
    }

    return num;
}

console.log(solution(test1));