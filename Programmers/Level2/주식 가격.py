def solution(prices):
    # 결과를 담을 배열
    answer = []
    # 처음부터 순회
    for i in range(0, len(prices)):
        # 현재 가격
        current = prices[i]
        # 마지막까지 남은 시간
        time = len(prices) - (i + 1)
        # 다음 가격들 순회
        for j in range(i + 1, len(prices)):
            temp = prices[j]
            # 현재가 다음 가격보다 높아질 때 time 새로 설정
            if current > temp:
                time = j - i
                break
        answer.append(time)

    return answer

print(solution([1, 2, 3, 2, 3]))