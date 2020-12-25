N = int(input())
time = 0
t = map(int, input().split())
y = m = 0
for x in t :
    y += (x // 30 + 1) * 10
    m += (x // 60 + 1) * 15

if y > m :
    print("M", m)
elif y < m :
    print("Y", y)
else :
    print("Y M", y)