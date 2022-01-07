def solution(x) :
    if x <= 1 :
        return 1
    return x * solution(x - 1)

n = int(input())
print(solution(n))