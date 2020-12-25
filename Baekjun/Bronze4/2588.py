first = int(input())
second = input()
array = []
for i in range(4) :
    if i < 3 :
        target = first * int(second[2-i], 10)
        array.append(target)

temp = []
for i in range(len(array)) :
    temp.append(array[i] * (10 ** i))
array.append(sum(temp))

for x in array :
    print(x)