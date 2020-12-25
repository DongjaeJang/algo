n = int(input())
array = []
for _ in range(n) :
    a, b = map(int, input().split())
    if a % 10 == 0 : array.append(10)
    else :
        focus = b % 4 + 4
        data = str(a ** focus)
        array.append(data[-1])

for order in array :
    print(order)