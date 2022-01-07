n = int(input())
balloons_list = [(index + 1, value) for index, value in enumerate(list(map(int, input().split())))]

answer_list = []
position = 0

while balloons_list:
    current = balloons_list.pop(position)
    answer_list.append(current[0])

    if not balloons_list : break
    if current[1] < 0 :
        position = (position + current[1]) % len(balloons_list)
    else :
        position = (position - (current[1] - 1)) % len(balloons_list)

for idx in answer_list :
    print(idx, end = ' ')

# # 왜맞지 이거 
# n = int(input())
# idx = 0
# result = []

# data = list(map(int, input().split()))
# index = [x for x in range(1, n + 1)]

# temp = data.pop(idx)
# result.append(index.pop(idx))

# while data:
#     if temp < 0:
#         idx = (idx + temp) % len(data)
#     else:
#         idx = (idx + (temp - 1)) % len(data)
#     temp = data.pop(idx)
#     result.append(index.pop(idx))

# for r in result:
#     print(r, end=' ')