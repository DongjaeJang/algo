def solution(n):
    answer = ''
    # 삼진법
    order = ['4', '1', '2']
    # 나머지를 answer에 추가
    while n:
        temp = n % 3
        n = n // 3
        # 나머지가 0일 때 -1을 안해주면 loop를 더돌아서 잘못된 값을 출력한다.
        if temp == 0:
            n -= 1
        answer = order[temp] + answer

    return answer

print(solution(10))