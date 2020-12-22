//test1
var locate1 = ["A1", "A2"];
var move1 = ["B", "L", "LB", "RB", "LT"];

//test2
var locate2 = ["A1", "A2"];
var move2 = ["B", "T", "RB", "R", "R"];
//test3
var locate3 = ["A1", "A8"];
var move3 = ["T","T","T","T","T","T","T","T","T","T","T","T","T","T","T","T","T"];


function solution (locate, move) {
    var row = "ABCDEFGH";

    var kingTemp = locate[0].split("");
    kingTemp[0] = row.indexOf(kingTemp[0]) + 1;
    kingTemp[1] = Number(kingTemp[1]);
    var stoneTemp = locate[1].split("");
    stoneTemp[0] = row.indexOf(stoneTemp[0]) + 1;
    stoneTemp[1] = Number(stoneTemp[1]);

    move.forEach((v) => {
        var tempX = 0;
        var tempY = 0;
        if (v === "R")
        {
            if (kingTemp[0] !== 8)
                tempX = 1;
        }
        else if (v === "L")
        {
            if (kingTemp[0] !== 1)
                tempX = -1;
        }
        else if (v === "B")
        {
            if (kingTemp[1] !== 1)
                tempY = -1;
        }
        else if (v === "T")
        {
            if (kingTemp[1] !== 8)
                tempY = 1;
        }
        else if (v === "RT")
        {
            if (kingTemp[0] !== 8 && kingTemp[1] !== 8)
            {
                tempX = 1;
                tempY = 1;
            }
        }
        else if (v === "LT")
        {
            if (kingTemp[0] !== 1 && kingTemp[1] !== 8)
            {
                tempX = -1;
                tempY = 1;
            }
        }
        else if (v === "RB")
        {
            if (kingTemp[0] !== 8 && kingTemp[1] !== 1)
            {
                tempX = 1;
                tempY = -1;
            }
        }
        else if (v === "LB")
        {
            if (kingTemp[0] !== 1 && kingTemp[1] !== 1)
            {
                tempX = -1;
                tempY = -1;
            }
        }

        kingTemp[0] += tempX;
        kingTemp[1] += tempY;

        if ((kingTemp[0] === stoneTemp[0]) && (kingTemp[1] === stoneTemp[1]))
        {
            stoneTemp[0] += tempX;
            stoneTemp[1] += tempY;

            if ((stoneTemp[0] < 0) || (stoneTemp[0] > 8) || (stoneTemp[1] < 0) || (stoneTemp[1] > 8))
            {
                stoneTemp[0] -= tempX;
                stoneTemp[1] -= tempY;
                kingTemp[0] -= tempX;
                kingTemp[1] -= tempY;
            }
        }
    });
    var king = row[kingTemp[0] - 1] + "" + kingTemp[1];
    var stone = row[stoneTemp[0] - 1] + "" + stoneTemp[1];

    var answer = [];
    answer.push(king);
    answer.push(stone);

    return answer;
}

console.log(solution(locate3, move3));