def solution(n):
    return int(''.join(sorted(list(str(n)), reverse = True)))

print(solution(12387841))