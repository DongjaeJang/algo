import math

def solution(n):
    x = math.sqrt(n)
    if x == math.floor(x) : return (x + 1) ** 2
    return -1

print(solution(121))