def solution(s):
    # 조건문에서 괄호를 통해서 우선순위를 정해줄 수 있음
    return True if (len(s) == 4 or len(s) == 6) and s.isdigit() else False

print(solution("a1234"))