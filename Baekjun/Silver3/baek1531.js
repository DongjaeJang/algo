// 투명

// test1
var n1 = 3;
var m1 = 1;
var test1 = ["21 21 80 80", "41 41 60 60", "71 71 90 90"];

function solution(n, m, test) {
    var board = [];
    for (var i = 0; i < 100; i++)
    {
        board[i] = [];
        for (var j = 0 ; j < 100; j++)
            board[i].push(0);
    }

    test.forEach((v) => {
        var temp = v.split(' ');
        for (var i = Number(temp[0])-1; i < Number(temp[2]); i++)
        {
            for (var j = Number(temp[1])-1; j < Number(temp[3]); j++)
                board[i][j] += 1;
        }
    });

    var answer = 0;
    board.forEach((v) => {
        v.forEach((i) => {
            if (i > m)
                answer += 1;
        })
    })

    return answer;
}

console.log(solution(n1, m1, test1));