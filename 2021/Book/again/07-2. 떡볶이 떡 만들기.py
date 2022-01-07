N, M = map(int, input().split())
array = list(map(int, input().split()))


def binarySearch(target, array):
    start = 0
    end = array[-1]
    result = -1
    while start <= end:
        height = (start + end) // 2
        length = sum([i - height for i in array if i > height])

        if length < M:
            end = height - 1
        else:
            start = height + 1
            result = height
    return result


array.sort()
print(binarySearch(M, array))
