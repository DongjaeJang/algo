def solution(answers):
    answer = []

    p1 = [1, 2, 3, 4, 5]
    p2 = [2, 1, 2, 3, 2, 4, 2, 5]
    p3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3]

    c1, c2, c3 = 0, 0, 0
    for i in range(len(answers)):
        if p1[i % 5] == answers[i]: c1 += 1
        if p2[i % 8] == answers[i]: c2 += 1
        if p3[i % 10] == answers[i]: c3 += 1

    maxCount = max([c1, c2, c3])
    if maxCount == c1: answer.append(1)
    if maxCount == c2: answer.append(2)
    if maxCount == c3: answer.append(3)

    return answer

solution([1,2,3,4,5])