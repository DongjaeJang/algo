//test1
var start1 = "2008 12 27";
var end1 = "2009 1 22";
//test2
var start2 = "1 12 1";
var end2 = "1111 1 1";


function solution (start, end) {
    var month_31 = [1, 3, 5, 7, 8, 10, 12];
    var month_30 = [4, 6, 9, 11];

    var temp_start = start.split(" ");
    var start_year = Number(temp_start[0]);
    var start_month = Number(temp_start[1]);
    var start_day = Number(temp_start[2]);
    var temp_end = end.split(" ");
    var end_year = Number(temp_end[0]);
    var end_month = Number(temp_end[1]);
    var end_day = Number(temp_end[2]);

    if (end_year - start_year >= 1000)
        return "gg";
    var temp_start_day = start_day;
    var temp_end_day = end_day;

    // start day
    for (var i = 1; i < start_year; i++)
    {
        if (i % 4 === 0)
        {
            if (i % 400 === 0)
                temp_start_day += 366;
            else if (i % 100 === 0)
                temp_start_day += 365;
            else
                temp_start_day += 366;
        }
        else
            temp_start_day += 365;
    }
    for (var i = 1; i < start_month; i++)
    {
        if (month_31.includes(i))
            temp_start_day += 31;
        else if (month_30.includes(i))
            temp_start_day += 30;
        else {
            if (start_year % 4 === 0)
            {
                if (start_year % 400 === 0)
                    temp_start_day += 29;
                else if (start_year % 100 === 0)
                    temp_start_day += 28;
                else
                    temp_start_day += 29;
            }
            else
                temp_start_day += 28;
        }
    }

    // end day
    for (var i = 1; i < end_year; i++)
    {
        if (i % 4 === 0)
        {
            if (i % 400 === 0)
                temp_end_day += 366;
            else if (i % 100 === 0)
                temp_end_day += 365;
            else
                temp_end_day += 366;
        }
        else
            temp_end_day += 365;
    }
    for (var i = 1; i < end_month; i++)
    {
        if (month_31.includes(i))
            temp_end_day += 31;
        else if (month_30.includes(i))
            temp_end_day += 30;
        else {
            if (end_year % 4 === 0)
            {
                if (end_year % 400 === 0)
                    temp_end_day += 29;
                else if (end_year % 100 === 0)
                    temp_end_day += 28;
                else
                    temp_end_day += 29;
            }
            else
                temp_end_day += 28;
        }
    }

    return temp_end_day - temp_start_day;
}

console.log(solution(start1, end1));