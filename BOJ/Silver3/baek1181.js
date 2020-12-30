//test1
var words1 = ["but", "i", "wont", "hesitate", "no", "more", "no", "more", "it", "cannot", "wait", "im", "yours"];
//test2
var words2 = ["eungdang", "gold", "pig", "x", "kart", "very", "poor", "so", "easy", "butt", "book", "k", "g", "google"];
function solution (words) {

    var temp = [...new Set(words)];

    temp.sort((a, b) => {
        if (a.length === b.length)
            return a > b ? 1 : -1;
        else 
            return a.length - b.length;
    });

    return temp;
}

console.log(solution(words2));