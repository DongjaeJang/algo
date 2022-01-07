// test1
var points1 = [0, 0, 0, 1, 1, 0]
// test2
var points2 = [2, 0, 0, 0, 2, 1];
// test3
var points3 = [-1, 0, 0, -2, 2, 1];


function solution (points) {

    var a = [];
    var b = [];
    var c = [];

    points.forEach((v, i) => {
        if (i < 2)
            a.push(v);
        else if (i < 4)
            b.push(v);
        else
            c.push(v);
    })

    if ((a[0] === b[0] && a[1] === b[1]) || (a[0] === c[0] && a[1] === c[1]) || (b[0] === c[0] && b[1] === c[1]))
        return -1;

    // 2AB + 2AC
    var length1 = 2*(Math.sqrt(Math.pow((a[0]-b[0]), 2) + Math.pow((a[1] -b[1]), 2)) + Math.sqrt(Math.pow((a[0]-c[0]), 2) + Math.pow((a[1]-c[1]), 2)));
    // 2AB + 2BC
    var length2 = 2*(Math.sqrt(Math.pow((a[0]-b[0]), 2) + Math.pow((a[1] -b[1]), 2)) + Math.sqrt(Math.pow((b[0]-c[0]), 2) + Math.pow((b[1]-c[1]), 2)));
    // 2AC + 2BC
    var length3 = 2*(Math.sqrt(Math.pow((a[0]-c[0]), 2) + Math.pow((a[1] -c[1]), 2)) + Math.sqrt(Math.pow((b[0]-c[0]), 2) + Math.pow((b[1]-c[1]), 2)));
    
    var lengths = [length1, length2, length3].sort((a,b) => {return a-b;});

    return lengths[lengths.length-1] - lengths[0];
}

console.log(solution(points3));