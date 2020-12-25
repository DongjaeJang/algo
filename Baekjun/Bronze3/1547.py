N = int(input())
array = [1, 2, 3]
for i in range(N) :
    x, y = map(int, input().split())
    xi = array.index(x)
    yi = array.index(y)
    array[xi], array[yi] = array[yi], array[xi]

print(array[0])