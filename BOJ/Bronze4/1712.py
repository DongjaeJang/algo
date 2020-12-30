fix, var, val = map(int, input().split())
p = val - var
if p <= 0 : print(-1)
else :
    q = fix // p
    print(q + 1)