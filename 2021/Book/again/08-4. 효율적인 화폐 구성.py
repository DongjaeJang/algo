n, m = map(int, input().split())
coin = []
for _ in range(n):
    coin.append(int(input()))

array = [10001] * (m + 1)
array[0] = 0
for i in range(n):
    for j in range(coin[i], m + 1):
        if array[j - coin[i]] != 10001:
            array[j] = min(array[j], array[j - coin[i]] + 1)

print(array[m] if array[m] != 10001 else -1)
