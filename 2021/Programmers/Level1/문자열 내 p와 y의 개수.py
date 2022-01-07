def solution(s):
    result = 0
    for letter in s :
        if letter.lower() == 'p' : result += 1
        elif letter.lower() == 'y' : result -= 1

    return True if result == 0 else False

print(solution("PyPPPPPPyyyYYYyyPpp"))