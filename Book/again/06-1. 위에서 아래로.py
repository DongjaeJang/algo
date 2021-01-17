N = int(input())
array = []
for _ in range(N) :
    array.append(int(input()))
# sort = 배열 원본을 정렬한다. (원본 유지 x)
# sorted = 배열 원본을 복사한 뒤 새로운 배열을 정렬하여 리턴한다. (원본 유지 o)
array.sort(reverse = True)
print(array)