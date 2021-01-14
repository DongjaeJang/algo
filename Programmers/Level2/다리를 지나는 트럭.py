def solution(bridge_length, weight, truck_weights):
    onBridge = []
    time = 0
    result = []
    tlen = len(truck_weights)
    while True:
        # 첫 시작
        if not onBridge:
            current = truck_weights.pop(0)
            onBridge.append([current, 1])
            time += 1
        else:
            # 1초씩 증가
            for i in onBridge:
                i[1] += 1
            time += 1
            # 하중을 견디는 지
            if truck_weights:
                # 현재 총 무게
                onBridgeWeight = sum([i[0] for i in onBridge])
                # 넣어도 넘지 않으면
                if (onBridgeWeight + truck_weights[0]) <= weight:
                    current = truck_weights.pop(0)
                    onBridge.append([current, 1])

        # time이 length를 넘으면 pop
        if onBridge[0][1] == bridge_length:
            current = onBridge.pop(0)
            result.append(current[0])

        if len(result) == tlen:
            break

    return time + 1

print(solution(100, 100, [10,10,10,10,10,10,10,10,10,10]))