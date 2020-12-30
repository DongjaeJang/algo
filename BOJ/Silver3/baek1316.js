// test1
var string1 = ["happy", "new", "year"];
// test2
var string2 = ["aba", "abab", "abcabc", "a"];

function solution(string) {

    var tempString = string;
    var answer = 0;

    tempString.forEach((v) => {
        var temp = v.split('');
        var tempAlphabet = [];
        var error = 0;
        
        temp.forEach((alpha, index) => {
            if (index === 0)
                tempAlphabet.push(alpha);
            
            else {
                if (tempAlphabet.includes(alpha))
                {
                    if (temp[index-1] !== alpha)
                        error += 1;
                }
                else if (!tempAlphabet.includes(alpha))
                {
                    if (temp[index-1] !== alpha)
                        tempAlphabet.push(alpha);
                }
            }
        });

        if (error === 0)
            answer += 1;
    });

    return answer;
}

console.log(solution(string1));