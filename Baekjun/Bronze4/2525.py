hour, minute = map(int, input().split())
time = int(input())
phour = time // 60
pminute = time % 60

minute += pminute
if minute > 59 :
    minute -= 60
    hour += 1

hour += phour
if hour > 23 :
    hour -= 24

print(hour, minute)