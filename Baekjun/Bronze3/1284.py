# 각 숫자 사이 1
# 1은 2, 0은 4, 나머지 3
# 양 끝 1
array = []
while True :
    a = int(input())
    if a == 0 : break
    array.append(a)

result = []
for i in range(len(array)) :
    target = str(array[i])
    count = 0
    for j in range(len(target)) :
        if target[j] == '1' :
            count += 2
        elif target[j] == '0' :
            count += 4
        else :
            count += 3
    result.append(count + len(target) + 1)

for x in result :
    print(x)