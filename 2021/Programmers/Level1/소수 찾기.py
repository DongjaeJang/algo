def solution(n):
    array = [True] * (n + 1)
    # 배수를 모두 False로 처리한 뒤에 True인 갯수만 센다.
    for i in range(2, n + 1):
        for j in range(i + i, n + 1, i):
            if array[j] == False:
                continue
            else:
                array[j] = False

    result = 0
    for i in range(2, n + 1):
        if array[i]: result += 1

    return result

print(solution(15604840))