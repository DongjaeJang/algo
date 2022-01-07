from collections import deque

def solution(priorities, location):
    array = deque()
    for i in range(len(priorities)):
        array.append((i, priorities[i]))
    # index를 담을 배열
    result = []
    # 탐색 시작
    while array:
        # 가장 높은 priority
        maxPriority = max(array, key=lambda x: x[1])[1]
        # 맨 앞 순서
        currentIdx, currentPriority = array.popleft()
        # priority 비교 후 같으면 출력
        if currentPriority == maxPriority:
            result.append(currentIdx)
        # 작으면 맨 뒷 순서로
        else:
            array.append((currentIdx, currentPriority))

    return result.index(location) + 1

print(solution([2, 1, 3, 2], 2))