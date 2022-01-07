n = int(input())

INF = int(1e9)
array = [INF for _ in range(n + 1)]
array[0] = 0
array[1] = 0

for i in range(2, n+1):
    array[i] = min(array[i-1] + 1, array[i])
    if i % 2 == 0:
        array[i] = min(array[i // 2] + 1, array[i])
    if i % 3 == 0:
        array[i] = min(array[i // 3] + 1, array[i])
    if i % 5 == 0:
        array[i] = min(array[i // 5] + 1, array[i])

print(array[n])
