from math import gcd
# 최대공약수로 구할 수 있음
# 잘려나가는 부분 => 가로 + 세로 - 1
def solution(w,h):
    total = w * h
    yaksu = gcd(w, h)
    newW = w // yaksu
    newH = h // yaksu

    return total - (newW + newH - 1) * yaksu

print(solution(8, 12))