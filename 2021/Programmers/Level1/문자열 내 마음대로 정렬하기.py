def solution(strings, n):
    # sort와 sorted의 차이
    # 1. sort : 기존 배열의 순서를 변경시키는 것이므로 return 값은 없다
    # 2. sorted : 기존 배열을 복사해서 순서를 바꾼 배열을 return 한다.
    
    # 배열의 정렬 순서는 key 값을 통해서 진행하고, 다중 정렬의 경우 조건을 순서대로 튜플에 넣는다.
    # 현 조건은 string의 n번째 글자를 기준으로 정렬한 뒤, 두번째로 사전 순 오름차순 정렬한 것
    return sorted(strings, key = lambda string : (string[n], string))

print(solution(["ace", "abcd", "abce"], 2))