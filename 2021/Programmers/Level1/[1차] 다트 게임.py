def solution(dartResult):
    point = []
    answer = []
    # 10을 먼저 k로 치환해준뒤에 분리
    dartResult = dartResult.replace('10', 'k')
    # k를 10으로 변경
    point = ['10' if i == 'k' else i for i in dartResult]

    bonus = ['S', 'D', 'T']
    option = ['*', '#']

    for current in point:
        # 보너스
        if current in bonus:
            answer[-1] = answer[-1] ** (bonus.index(current) + 1)
        # 옵션
        elif current in option:
            # 스타상
            if current == '*':
                # 처음에 나오면 현재만
                if len(answer) == 1:
                    answer[-1] *= 2
                # 아니면 이전과 현재
                else:
                    answer[-2] *= 2
                    answer[-1] *= 2
            # 아차상
            else:
                answer[-1] *= -1
        # 숫자
        else:
            answer.append(int(current))

    return sum(answer)

print(solution("1S2D*3T"))