// 정사각형

//test1
var n1 = 2;
var test1 = ["1 1", "1 2", "2 1", "2 2", "2 2", "3 3", "4 4", "5 5"];

function solution(n, test) {

    var points1 = [];
    var points2 = [];
    var points3 = [];
    var points4 = [];

    test.forEach((v, i) => {
        if (i % 4 === 0)
            points1.push(v);
        else if (i % 4 === 1)
            points2.push(v);
        else if (i % 4 === 2)
            points3.push(v);
        else
            points4.push(v);
    });

    var answerList = [];
    for (var i = 0; i < n; i++) {
        var p1 = points1[i].split(' ');
        var p2 = points2[i].split(' ');
        var p3 = points3[i].split(' ');
        var p4 = points4[i].split(' ');
        p1[0] = Number(p1[0]); p1[1] = Number(p1[1]);
        p2[0] = Number(p2[0]); p2[1] = Number(p2[1]);
        p3[0] = Number(p3[0]); p3[1] = Number(p3[1]);
        p4[0] = Number(p4[0]); p4[1] = Number(p4[1]);
        var tempList = [];
        tempList.push(Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]));
        tempList.push(Math.abs(p1[0] - p3[0]) + Math.abs(p1[1] - p3[1]));
        tempList.push(Math.abs(p1[0] - p4[0]) + Math.abs(p1[1] - p4[1]));
        tempList.push(Math.abs(p2[0] - p3[0]) + Math.abs(p2[1] - p3[1]));
        tempList.push(Math.abs(p2[0] - p4[0]) + Math.abs(p2[1] - p4[1]));
        tempList.push(Math.abs(p3[0] - p4[0]) + Math.abs(p3[1] - p4[1]));
        var length = [...new Set(tempList)];

        length.length === 2 ? answerList.push(1) : answerList.push(0);
    }

    var answer = "";
    answerList.forEach((v) => { answer += (v + '\n'); });

    return answer;
}


console.log(solution(n1, test1));