from math import gcd

def solution(n, m):
    return [gcd(n, m), lcm(n, m)]

def lcm(n, m) :
    return n * m // gcd(n, m)

print(solution(1, 10))