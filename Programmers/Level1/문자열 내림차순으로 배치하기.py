def solution(s):
    #문자열을 sorted로 하면 배열이 리턴되므로 문자열로 반환하기 위해 ''.join 사용
    return ''.join(sorted(s, reverse = True))

print(solution("Zbcdefg"))