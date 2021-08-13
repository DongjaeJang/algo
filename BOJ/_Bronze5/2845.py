people, area = map(int, input().split())
news = list(map(int,input().split()))

total = people * area
dif = list()
for compare in news :
    dif.append(compare - total)

print(" ".join(map(str, dif)))