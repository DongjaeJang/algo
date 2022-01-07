def solution(arr):
    array = []

    for num in arr:
        if not array:
            array.append(num)
        else:
            if array[-1] != num:
                array.append(num)

    return array

print(solution([1,1,3,3,0,1]))