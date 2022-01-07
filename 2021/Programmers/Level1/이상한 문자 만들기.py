def solution(s):
    answer = ''
    array = s.split(' ')
    for string in array:
        for i in range(len(string)):
            if i % 2 == 0:
                answer += string[i].upper()
            elif i % 2 == 1:
                answer += string[i].lower()
        answer += ' '

    return answer[0:-1]

print(solution("try Hello WorLD"))