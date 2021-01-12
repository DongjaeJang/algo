def solution(x):
    divisor = sum(list(map(int, str(x))))
    return True if x % divisor == 0 else False

print(solution(18))