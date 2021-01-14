def solution(numbers):
    answer = merge_sort(numbers)

    return ''.join(answer) if answer[0] != '0' else '0'


def merge_sort(array):
    if len(array) == 1:
        return array
    mid = len(array) // 2
    left = array[:mid]
    right = array[mid:]
    return merge(merge_sort(left), merge_sort(right))


def merge(left, right):
    result = []
    left = [str(i) for i in left]
    right = [str(i) for i in right]
    while left and right:
        if (left[0] + right[0]) > (right[0] + left[0]):
            result.append(left.pop(0))
        else:
            result.append(right.pop(0))
    while left:
        result.append(left.pop(0))
    while right:
        result.append(right.pop(0))
    return result

print(solution([3, 30, 34, 5, 9]))