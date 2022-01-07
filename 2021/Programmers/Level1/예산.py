def solution(d, budget):
    d.sort()
    if d[0] > budget: return 0

    for i in range(len(d)):
        if sum(d[0:i + 1]) > budget: return i

    return len(d)

print(solution([1,3,2,5,4], 9))