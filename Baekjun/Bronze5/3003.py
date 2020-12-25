origin = [1, 1, 2, 2, 2, 8]
compare = list(map(int, input().split()))
result = list()
for i in range(len(compare)) :
    result.append(origin[i] - compare[i])
print(" ".join(map(str, result)))
