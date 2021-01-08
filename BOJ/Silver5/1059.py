L = int(input())
L_list = sorted(list(map(int, input().split())))
N = int(input())
start = 0

if N in L_list:
    print(0)
else:
    for i in L_list:
        if N > i:
            start = i + 1
        else:
            end = i - 1
            break
    print(end - start + (end - N) * (N - start))