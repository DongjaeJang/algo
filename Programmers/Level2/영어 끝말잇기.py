def solution(n, words):
    used = []
    order = []

    # 순서 재배치
    temp = []
    for word in words:
        temp.append(word)
        if len(temp) == n:
            order.append(temp)
            temp = []

    # 차례로 돌면서 확인
    for i in range(len(order)):
        game = order[i]
        for j in range(len(game)):
            word = game[j]
            if word in used:
                return [j + 1, i + 1]
            if not used:
                used.append(word)
            else:
                before = used[-1]
                if before[-1] == word[0]:
                    used.append(word)
                else:
                    return [j + 1, i + 1]

    return [0, 0]

solution(3, ["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"])