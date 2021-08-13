array = list(map(int, input().split()))
data = dict()
for x in array :
    if not x in data.keys() :
        data[x] = 0
    data[x] += 1

price = 0
same = 0
dlen = len(data)
if dlen == 1 :
    for key in data :
        if data[key] == 3 :
            same = key
    price = 10000 + same * 1000
elif dlen == 2 :
    for key in data :
        if data[key] == 2 :
            same = key
    price = 1000 + same * 100
else :
    same = max(array)
    price = same * 100

print(price)