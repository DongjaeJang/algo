N = int(input())
shop = list(map(int, input().split()))
M = int(input())
customer = list(map(int, input().split()))


def binarySearch(target, shop):
    start = 0
    end = len(shop) - 1

    while start <= end:
        mid = (start + end) // 2
        if shop[mid] == target:
            return "yes"
        elif shop[mid] > target:
            end = mid - 1
        else:
            start = mid + 1

    return "no"


for target in customer:
    print(binarySearch(target, shop))
