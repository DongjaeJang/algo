def solution(array, commands):
    result = []
    clen = len(commands)
    for i in range(clen):
        start, end, target = commands[i]
        result.append(sorted(array[start - 1: end])[target - 1])

    return result

solution([1, 5, 2, 6, 3, 7, 4], [[2, 5, 3], [4, 4, 1], [1, 7, 3]])