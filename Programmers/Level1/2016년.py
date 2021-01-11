def solution(a, b):
    months = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    weeks = ["FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"]
    days = 0
    for i in range(1, a):
        days += months[i]
    days += b - 1

    return weeks[days % 7]

solution(5, 24)