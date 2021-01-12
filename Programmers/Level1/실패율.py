def solution(N, stages):
    answer = []
    length = len(stages)

    for stage in range(1, N + 1):
        stay = stages.count(stage)
        if length == 0:
            failure = 0
        else:
            failure = stay / length

        answer.append((stage, failure))
        length -= stay

    answer = sorted(answer, key=lambda x: x[1], reverse=True)
    return [i[0] for i in answer]

print(solution(5, [2, 1, 2, 6, 2, 4, 3, 3]))