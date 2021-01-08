from math import gcd
n = int(input())

def lcm(a, b) :
    return a * b // gcd(a, b)

for _ in range(n) :
    a, b = map(int, input().split())
    print(lcm(a, b))

