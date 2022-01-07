def solution(n, a, b):
    ans = 1
    # 대소 비교해서 순서를 바꿔줌
    if a > b:
        a, b = b, a

    while True:
        if b - a == 1 and b % 2 == 0:
            return ans
        if a % 2 == 0:
            a = a // 2
        else:
            a = a // 2 + 1
        if b % 2 == 0:
            b = b // 2
        else:
            b = b // 2 + 1
        ans += 1

solution(8,4,7)