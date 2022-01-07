def solution(arr, divisor):
    arr.sort()
    answer = []
    for num in arr:
        if num % divisor == 0: answer.append(num)

    # 삼항연산자를 파이썬에서는 이렇게 사용한다
    return answer if answer else [-1]

print(solution([5,4,7,12,15], 5))