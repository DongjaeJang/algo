// test1
var list1 = [5, 7, 7];
// test2
var list2 = [7, 6, 6];
// test3
var list3 = [4, 6, 2, 7, 9, 10];
// test4
var list4 = [1];
// test5
var list5 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

function solution(list) {
    if (Math.max.apply(null, list) === list[0] || list.length === 1)
        return 0;

    var person = 0;

    while (true)
    {
        var tempMax = Math.max.apply(null, list);
        var tempMaxList = [];
        list.forEach((v, i) => {
            if (v === tempMax)
            {
                tempMaxList.push({value : v, index : i});
            }
        });

        if ((list[0] === tempMax) && (tempMaxList.length === 1))
            break;
        
        if (tempMaxList.length === 1)
        {
            list[tempMaxList[0].index] -= 1;
            list[0] += 1;
            person += 1;
        }
        else if (tempMaxList.length >= 2)
        {
            list[tempMaxList[1].index] -= 1;
            list[0] += 1;
            person += 1;
        }
    }

    return person;
}

console.log(solution(list5));