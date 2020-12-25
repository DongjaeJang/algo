array = []
for _ in range(3) :
    n = int(input())
    temp = []
    for __ in range(n) :
        temp.append(int(input()))
    _sum = sum(temp)
    if _sum == 0 : array.append('0')
    elif _sum < 0 : array.append('-')
    else : array.append('+')

for x in array :
    print(x)