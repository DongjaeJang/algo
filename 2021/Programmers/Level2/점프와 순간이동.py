# 이동 방법
# 1. 1칸 전진 => 건전지 1칸 소비
# 2. 온거리 *2로 순간이동 => 건전지 소비 x

def solution(n):
    ans = 0
    while n > 0:
        if n % 2 == 0:
            n = n // 2
        else:
            n -= 1
            ans += 1

    return ans

solution(5000)