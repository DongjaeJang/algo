// test1
var row1 = 8;
var col1 = 8;
var board1 = [
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBBBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW"
];
// test2
var row2 = 10;
var col2 = 13;
var board2 = [
    "BBBBBBBBWBWBW",
    "BBBBBBBBBWBWB",
    "BBBBBBBBWBWBW",
    "BBBBBBBBBWBWB",
    "BBBBBBBBWBWBW",
    "BBBBBBBBBWBWB",
    "BBBBBBBBWBWBW",
    "BBBBBBBBBWBWB",
    "WWWWWWWWWWBWB",
    "WWWWWWWWWWBWB"
]

const whiteStart = (row , col, board) => {
    var count = 0;
    var row_temp = 0;
    for (var i = row; i < row+8; i++) {
        var col_temp = 0;
        for (var j = col; j < col+8; j++) {
            if ((row_temp + col_temp) % 2 === 0 && board[i][j] !== "W")
                count += 1;
            else if ((row_temp + col_temp) % 2 === 1 && board[i][j] !== "B")
                count += 1;
            col_temp += 1;
        }
        row_temp += 1;
    }
    return count;
};

const blackStart = (row, col, board) => {
    var count = 0;
    var row_temp = 0;
    for (var i = row; i < row+8; i++) {
        var col_temp = 0;
        for (var j = col; j < col+8; j++) {
            if ((row_temp + col_temp) % 2 === 0 && board[i][j] !== "B")
                count += 1;
            else if ((row_temp + col_temp) % 2 === 1 && board[i][j] !== "W")
                count += 1;
            col_temp += 1;
        }
        row_temp += 1;
    }
    return count;
};

function solution (row, col, board) {

    var temp = [];
    board.forEach((v, i) => {
        temp[i] = v.split('');
    });

    answer = [];
    for (var i = 0; i < row - 7; i++)
    {
        for (var j = 0; j < col - 7; j++)
        {
            var count = 0;
            if (temp[i][j] === "W")
                count = whiteStart(i,j,temp);
            else if(temp[i][j] === "B")
                count = blackStart(i,j,temp);

            answer.push(count);
        }
    }
    answer.sort((a,b) => {return a-b;});

    return answer[0];
}

console.log(solution(row1, col1, board1));