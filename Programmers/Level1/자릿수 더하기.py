def solution(n):
    # map으로 자료형 변환
    return sum(list(map(int, str(n))))

print(solution(987))