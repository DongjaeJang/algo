def sort(list):
    for i in range(len(list) - 1):
        for j in range(len(list) - i - 1):
            if list[j + 1] < list[j]:
                list[j], list[j + 1] = list[j + 1], list[j]
    return list


def uniqueSet(list):
    result = []
    for i in range(len(list)):
        if i == 0:
            result.append(list[i])
        else:
            count = 0
            for j in range(len(result)):
                if list[i] == result[j]:
                    count = 1
                    break
            if count == 1:
                continue
            result.append(list[i])
    return result


def plus(list):
    result = []
    for i in range(len(list) - 1):
        for j in range(len(list) - i - 1):
            sum = list[i] + list[i + j + 1]
            result.append(sum)
    return result


def solution(numbers):
    answer = []
    list = numbers
    list = plus(list)
    answer = sort(uniqueSet(list))

    return answer

solution([2,1,3,4,1])