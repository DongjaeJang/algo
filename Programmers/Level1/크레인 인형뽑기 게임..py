def solution(board, moves):
    answer = 0
    stack = []
    height = len(board)

    for column in moves:
        x = column - 1
        for i in range(height):
            if board[i][x] != 0:
                target = board[i][x]
                if len(stack) == 0:
                    stack.append(target)
                else:
                    if stack[-1] == target:
                        answer += 2
                        stack.pop()
                    else:
                        stack.append(target)
                board[i][x] = 0
                break

    return answer

solution([[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]], [1,5,3,5,1,2,1,4])