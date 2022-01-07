from itertools import combinations


def solution(nums):
    array = list(combinations(nums, 3))

    sum_arr = []
    for i in array:
        sum_arr.append(sum(i))

    return isSosu(sum_arr)


def isSosu(arr):
    result = 0
    for target in arr:
        isOkay = True
        for j in range(2, target):
            if target % j == 0:
                isOkay = False
                break
        if isOkay:
            result += 1

    return result

solution([1,2,7,6,4])