N = int(input())
storages = list(map(int, input().split()))

array = [0 for _ in range(N)]
array[0] = storages[0]
array[1] = max(array[0], storages[1])

for i in range(2, N):
    array[i] = max(array[i - 2] + storages[i], array[i])

print(array[N - 1])
