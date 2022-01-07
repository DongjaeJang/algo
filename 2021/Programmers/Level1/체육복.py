def solution(n, lost, reserve):
    answer = 0
    hash = [1] * (n + 1)

    for key in reserve:
        hash[key] += 1

    for key in lost:
        hash[key] -= 1

    for i in range(1, n + 1):
        if hash[i] == 2:
            if i == 0:
                if hash[i + 1] == 0:
                    hash[i + 1] += 1
                    hash[i] -= 1
            elif i == n:
                if hash[i - 1] == 0:
                    hash[i - 1] += 1
                    hash[i] -= 1
            else:
                if hash[i - 1] == 0:
                    hash[i - 1] += 1
                    hash[i] -= 1
                elif hash[i + 1] == 0:
                    hash[i + 1] += 1
                    hash[i] -= 1

    result = 0
    for i in range(1, n + 1):
        if hash[i] > 0:
            result += 1

    return result

solution(5, [2,4], [1,3,5])