def solution(participant, completion):
    answer = ''
    participant.sort()
    completion.sort()

    for i in range(len(completion)):
        if completion[i] != participant[i]:
            return participant[i]

    if answer == '':
        answer = participant[-1]

    return answer

solution(["leo", "kiki", "eden"], ["eden", "kiki"])