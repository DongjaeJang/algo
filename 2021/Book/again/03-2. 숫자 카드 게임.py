# N, M : 행, 열
N, M = map(int, input().split())

result = -1
# 행의 최솟값들 중 최댓값
for _ in range(N) :
    array = list(map(int, input().split()))
    if result < min(array) :
        result = min(array)
        
print(result)