// test1
var route1 = "A1 B3 A5 C6 E5 F3 D2 F1 E3 F5 D4 B5 A3 B1 C3 A2 C1 E2 F4 E6 C5 A6 B4 D5 F6 E4 D6 C4 B6 A4 B1 D1 F2 D3 E1 C2"



function solution(route) {
    var temp = route.split(' ');
    var list = [];

    var dx = [ 1, 2, 2, 1, -1, -2, -2, -1];
    var dy = [ 2, 1, -1, -2, -2, -1, 1, 2];

    var newTemp = [...new Set(temp)];
    if (newTemp.length !== 36)
        return "Invalid";

    newTemp.forEach((value, index) => {
        var location = value.split('');
        if (index === 0)
        {
            list.push(value);
        }
        else if (index !== 0)
        {
            if (!list.includes(value))
                list.push(value);
        }
    });
    
    return list.length === 36 ? "Valid" : "Invalid";
}

console.log(solution(route1));