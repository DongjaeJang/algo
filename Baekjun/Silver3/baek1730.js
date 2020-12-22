// 판화
var n1 = 6;
var test1 = "DRDRRUU";


function solution(n, test) {

    var board = [];
    for (var i = 0; i < n; i++)
    {
        board[i] = [];
        for (var j = 0; j < n; j++)
            board[i].push(String.fromCharCode(46));
    }

    var locationX = 0;
    var locationY = 0;
    test.split('').forEach((v) => {
        if (v === 'U')
        {
            if (locationX > 0)
            {
                if (board[locationX][locationY] === String.fromCharCode(45))
                    board[locationX][locationY] = String.fromCharCode(43);
                else if (board[locationX][locationY] === String.fromCharCode(46))
                    board[locationX][locationY] = String.fromCharCode(124);

                if (board[locationX-1][locationY] === String.fromCharCode(45))
                    board[locationX-1][locationY] = String.fromCharCode(43);
                else if (board[locationX-1][locationY] === String.fromCharCode(46))
                    board[locationX-1][locationY] = String.fromCharCode(124);
                
                locationX -= 1;
            }
        }
        else if (v === 'D')
        {
            if (locationX < n-1)
            {
                if (board[locationX][locationY] === String.fromCharCode(45))
                    board[locationX][locationY] = String.fromCharCode(43);
                else if (board[locationX][locationY] === String.fromCharCode(46))
                    board[locationX][locationY] = String.fromCharCode(124);
                    
                if (board[locationX+1][locationY] === String.fromCharCode(45))
                    board[locationX+1][locationY] = String.fromCharCode(43);
                else if (board[locationX+1][locationY] === String.fromCharCode(46))
                    board[locationX+1][locationY] = String.fromCharCode(124);

                locationX += 1;
            }
        }
        else if (v === 'L')
        {
            if (locationY > 0)
            {
                if (board[locationX][locationY] === String.fromCharCode(124))
                    board[locationX][locationY] = String.fromCharCode(43);
                else if (board[locationX][locationY] === String.fromCharCode(46))
                    board[locationX][locationY] = String.fromCharCode(45);

                if (board[locationX][locationY-1] === String.fromCharCode(124))
                    board[locationX][locationY-1] = String.fromCharCode(43);
                else if (board[locationX][locationY-1] === String.fromCharCode(46))
                    board[locationX][locationY-1] = String.fromCharCode(45);
                
                locationY -= 1;
            }
        }
        else if (v === 'R')
        {
            if (locationY < n - 1)
            {
                if (board[locationX][locationY] === String.fromCharCode(124))
                    board[locationX][locationY] = String.fromCharCode(43);
                else if (board[locationX][locationY] === String.fromCharCode(46))
                    board[locationX][locationY] = String.fromCharCode(45);

                if (board[locationX][locationY+1] === String.fromCharCode(124))
                    board[locationX][locationY+1] = String.fromCharCode(43);
                else if (board[locationX][locationY+1] === String.fromCharCode(46))
                    board[locationX][locationY+1] = String.fromCharCode(45);
                
                locationY += 1;
            }
        }
    });

    return board;
}

console.log(solution(n1, test1));