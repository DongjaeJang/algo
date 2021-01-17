N = int(input())
array = []
for _ in range(N) :
    data = input().split()
    array.append((data[0], int(data[1])))
print([i[0] for i in sorted(array, key = lambda x : x[1])])
