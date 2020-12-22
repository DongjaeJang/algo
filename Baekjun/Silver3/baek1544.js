// 사이클 단어

// test1
var test1 = "picture\nturepic\nicturep\nword\nordw";


function solution (test) {

    var temp = test.split('\n');
    var list = [];
    var answer = 0;

    temp.forEach((v) => {
        if (list.length === 0) {
            list.push(v);
            answer += 1;
        }
        else
        {
            var count  = 0;
            for (var i = 1; i < v.length; i++)
            {
                var word1 = v.slice(0, i);
                var word2 = v.slice(i);

                if (list.includes(word2+word1)) {
                    count += 1;
                    break;
                }
            }
            if (count === 0) {
                list.push(v);
                answer += 1;
            }
        }
    })
    return answer;
}

console.log(solution(test1));