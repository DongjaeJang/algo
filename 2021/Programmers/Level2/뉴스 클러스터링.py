import re
from collections import Counter

def solution(str1, str2):
    answer = 0
    delete = '[^a-zA-Z]'

    array1 = []
    array2 = []
    # str1 나누기
    for i in range(1, len(str1)):
        target = str1[i - 1] + str1[i]
        result = re.sub(delete, '', target)
        if len(result) == 2:
            array1.append(target.lower())
    # str2 나누기
    for i in range(1, len(str2)):
        target = str2[i - 1] + str2[i]
        result = re.sub(delete, '', target)
        if len(result) == 2:
            array2.append(target.lower())

    if not array1 and not array2:
        return 65536

    set1 = Counter(array1)
    set2 = Counter(array2)

    interSetLen = len(list((set1 & set2).elements()))
    unionSetLen = len(list((set1 | set2).elements()))

    return int(interSetLen / unionSetLen * 65536)

solution("FRANCE", "french")