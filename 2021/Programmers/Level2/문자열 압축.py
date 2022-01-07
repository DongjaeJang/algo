def solution(s):
    answer = 1e9
    midlen = len(s) // 2

    for i in range(1, midlen + 2):
        tempStr = s[0:]
        tempArray = []
        # 길이별로 잘라서 tempArray 생성
        while tempStr:
            temp = tempStr[0:i]
            tempStr = tempStr[i:]
            tempArray.append(temp)
        # 문자열을 담을 배열
        stack = []
        while tempArray:
            current = tempArray.pop(0)
            if not stack:
                stack.append(current)
            else:
                last = stack[-1]
                if last != current:
                    stack.append(current)
                else:
                    # 스택 길이가 1이면 무조건 2 추가
                    if len(stack) == 1:
                        stack.pop()
                        stack.append(str(2))
                        stack.append(current)
                    # 아니면
                    elif len(stack) > 1:
                        nextLast = stack[-2]
                        # 숫자면 빼서 더해준다
                        if nextLast.isdigit():
                            last = stack.pop()
                            nextLast = int(stack.pop())
                            stack.append(str(nextLast + 1))
                            stack.append(last)
                        # 아니면 갯수 추가
                        else:
                            last = stack.pop()
                            stack.append(str(2))
                            stack.append(last)
        # 길이 출력
        tempLen = len(''.join(stack))
        # 현재 값보다 작으면 대입
        if answer > tempLen:
            answer = tempLen

    return answer

print(solution("abcabcabcabcdededededede"))