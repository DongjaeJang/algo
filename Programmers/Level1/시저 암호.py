def solution(s, n):
    answer = ''
    # ord : 문자를 아스키코드 번호로 변환
    # chr : 아스키코드 번호를 문자로 변환
    for letter in s:
        if letter == ' ':
            answer += letter
        elif 'a' <= letter <= 'z':
            o = ord(letter) + n
            if o > 122: o -= 26
            answer += chr(o)
        elif 'A' <= letter <= 'Z':
            o = ord(letter) + n
            if o > 90: o -= 26
            answer += chr(o)

    return answer

print(solution("a B z", 4))