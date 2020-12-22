//test1
var word1 = "mobitel"
//test2
var word2 = "djqjeakjaa";
//test3
var word3 = "aaabaaa";

function solution(word) {
    var len = word.length;
    var wordlist = [];
    
    for (var x = 1; x <= len-1; x++) {

        for (var y = 1; y <= len-1-x; y++) {

            var tempA = word.slice(0, x).split("").reverse().join("");
            var tempB = word.slice(x, x + y).split("").reverse().join("");
            var tempC = word.slice(x + y).split("").reverse().join("");

            wordlist.push(tempA+tempB+tempC);
        }
    }
    wordlist.sort((a,b) => {return a > b ? 1 : -1;});

    return wordlist[0];
}

console.log(solution(word3));