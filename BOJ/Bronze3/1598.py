a, b = map(int, input().split())
a-=1
b-=1
ax, ay = a // 4, a % 4
bx, by = b // 4, b % 4

print(abs(ax-bx) + abs(ay-by))