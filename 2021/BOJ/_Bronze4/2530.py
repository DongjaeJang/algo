hour, minute, second = map(int, input().split())
time = int(input())

psecond = time % 60
pminute = time // 60
phour = pminute // 60
pminute = pminute % 60

second += psecond
minute += pminute
hour += phour
if second > 59 :
    minute += second // 60
    second %= 60
if minute > 59 :
    hour += minute // 60
    minute %= 60
if hour > 23 :
    hour %= 24

print(hour, minute, second)