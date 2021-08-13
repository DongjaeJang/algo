import math
d, h, w = map(int, input().split())
# h < w
k = d / math.sqrt(h**2 + w**2)
print(math.floor(h*k), math.floor(w*k))