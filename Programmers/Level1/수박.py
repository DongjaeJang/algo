def solution(n):
    q, r = divmod(n, 2)
    return "수박" * q if r == 0 else "수박" * q + "수"

print(solution(5))