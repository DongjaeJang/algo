// test1
var n1 = 5;
var p1 = [2, 8, 10, 7];
// test2
var n2 = 7;
var p2 = [3, 2, 8, 10, 12, 18, 15, 40, 120];
// test3
var n3 = 10;
var p3 = [723, 1026, 616, 1226, 634, 704];

function solution (n, p) {
    var result = -1;
    var temp_p = p;
    var price = 0;
    temp_p.forEach((v) => {
        var people = temp_p.filter((value) => { return value >= v; });
        if (n > people.length) {
            if (result < v * people.length) {
                result = v * people.length;
                price = v;
            }
        }
        else {
            if (result < v * n) {
                result = v * n;
                price = v;
            }
        }
    });

    return price + " " +result;
}

console.log(solution(n3, p3));