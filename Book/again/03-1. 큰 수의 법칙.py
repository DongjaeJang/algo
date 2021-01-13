# N, M, K : 자연수 갯수, 총 횟수, 최대 반복 수
N, M, K = map(int, input().split())
# numList : 자연수를 담은 배열
numList = list(map(int, input().split()))

numList.sort(reverse=True)
# 제일 큰 수 * K + 두번째 큰 수 * 1 이 반복됨
q = M // (K + 1)
r = M % (K + 1)

first = numList[0]
second = numList[1]

result = q * (first * 3 + second) + r * first

print(result)