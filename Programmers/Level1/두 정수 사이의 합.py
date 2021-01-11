def solution(a, b):
    # 대소관계가 정해지지 않았으므로 정해준다
    if a > b : a, b = b, a
    # 배열에 한번에 넣는 방법
    return sum([x for x in range(a, b+1)])

print(solution(3, 5))