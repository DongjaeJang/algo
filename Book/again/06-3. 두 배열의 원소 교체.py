N, K = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

while K :
    A.sort()
    B.sort(reverse=True)
    if A[0] < B[0] :
        minA = A.pop(0)
        maxB = B.pop(0)
        A.append(maxB)
        B.append(minA)
        K -= 1
    else :
        break

print(sum(A))
