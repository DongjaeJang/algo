# 이동방향이 8개 밖에 안되므로 체크
location = input()
row = int(location[1])
col = int(ord(location[0]) - ord('a')) + 1

moves = [(2, 1), (2, -1), (1, -2), (1, 2), (-1, -2), (-1, 2), (-2, 1), (-2, -1)]

count = 0
for move in moves :
    (x, y) = move
    nextX = row + x
    nextY = col + y
    if 1 <= nextX <= 8 and 1 <= nextY <= 8 :
        count += 1

print(count)