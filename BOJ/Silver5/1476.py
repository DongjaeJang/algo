y, m, d = map(int, input().split())

tempy = tempm = tempd = 1
count = 1
while True :
    if tempy == y and tempm == m and tempd == d : break
    tempy += 1
    tempm += 1
    tempd += 1
    if tempy == 16 : tempy = 1
    if tempm == 29 : tempm = 1
    if tempd == 20 : tempd = 1
    count += 1

print(count)