def solution(phone_number):
    slen = len(phone_number) - 4
    return '*' * slen + phone_number[slen:]

print(solution("01055811156"))