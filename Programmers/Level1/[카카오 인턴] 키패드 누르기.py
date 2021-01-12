def solution(numbers, hand):
    answer = ''
    # 키패드
    keypads = [[1, 2, 3], [4, 5, 6], [7, 8, 9], ['-', 0, '*']]
    # 시작 손가락 위치
    leftX, leftY = 3, 0
    rightX, rightY = 3, 2

    for number in numbers:
        # 왼쪽
        if number == 1 or number == 4 or number == 7:
            answer += 'L'
            [(leftX, leftY)] = findLocation(number, keypads)
        # 오른쪽
        elif number == 3 or number == 6 or number == 9:
            answer += 'R'
            [(rightX, rightY)] = findLocation(number, keypads)
        # 가운데일 때는 거리 비교
        else:
            left = findDistance(number, keypads, leftX, leftY)
            right = findDistance(number, keypads, rightX, rightY)
            if left > right:
                answer += 'R'
                [(rightX, rightY)] = findLocation(number, keypads)
            elif right > left:
                answer += 'L'
                [(leftX, leftY)] = findLocation(number, keypads)
            else:
                if hand == 'right':
                    answer += 'R'
                    [(rightX, rightY)] = findLocation(number, keypads)
                else:
                    answer += 'L'
                    [(leftX, leftY)] = findLocation(number, keypads)

    return answer


# 타겟 위치 찾기
def findLocation(number, keypads):
    return [(i, j) for i in range(4) for j in range(3) if keypads[i][j] == number]


# 타겟 위치까지 거리 구하기
def findDistance(number, keypads, currentX, currentY):
    [(targetX, targetY)] = findLocation(number, keypads)
    return abs(targetX - currentX) + abs(targetY - currentY)

print(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], "right"))