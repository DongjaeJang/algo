def solution(skill, skill_trees):
    answer = 0
    # 스킬 순서
    order = list(skill)
    # 하나씩 순회
    for s in skill_trees:
        temp = []
        # 관련있는 스킬들 모음
        for letter in s:
            if letter in order:
                temp.append(letter)
        isOkay = True
        for i in range(len(temp)):
            # 만약 순서가 같지 않다면 올바른 스킬트리가 아니므로 False
            if temp[i] != order[i]:
                isOkay = False
                break
        if isOkay:
            answer += 1

    return answer

print(solution("CBD", ["BACDE", "CBADF", "AECB", "BDA"]))