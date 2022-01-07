def solution(n):
    return int(n_ary(n, 3)[::-1], 3);

# divmod로 몫과 나머지를 한번에 구할 수 있다.
def n_ary(n, base):
    result = []

    while n > 0:
        n, r = divmod(n, base)
        result.append(r)

    return ''.join(map(str, reversed(result)))

print(solution(45))