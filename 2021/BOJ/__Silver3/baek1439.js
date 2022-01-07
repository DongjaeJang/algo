// 뒤집기

//test1
var s1 = "0001100";
//test2
var s2 = "0100110110";

function solution(s) {
    
    var temp0 = 0;
    var temp1 = 0;
    var tempList = [];

    s.split('').forEach(v => {
        if (tempList.length === 0) {
            if (v === '0')
                temp0 += 1;
            else if (v === 1)
                temp1 += 1;

            tempList.push(v);
        }
        else {
            if (v === tempList[tempList.length - 1])
                tempList.push(v);
            else {
                if (v === '0')
                    temp0 += 1;
                else if (v === '1')
                    temp1 += 1;

                tempList.push(v);
            }
        }
    })

    return temp0 >= temp1 ? temp1 : temp0;
}

console.log(solution(s2));