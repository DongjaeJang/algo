def solution(s):
    slen = len(s)
    mid = slen // 2

    if slen % 2 == 0:
        return s[mid - 1:mid + 1]
    else:
        return s[mid]

print(solution("abcdef"))
print(solution("bcd"))