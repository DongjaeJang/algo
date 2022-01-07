n = int(input())

binN = bin(n)[2:]
result = 0
for i in range(len(binN)) :
    if binN[i] == '1':
        result += 1

print(result)