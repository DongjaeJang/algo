def solution(n, arr1, arr2):
    arr1 = [format(target, 'b') for target in arr1]
    arr2 = [format(target, 'b') for target in arr2]

    _arr1 = []
    _arr2 = []

    for target in arr1:
        while len(target) < len(arr1):
            target = '0' + target
        _arr1.append(target)

    for target in arr2:
        while len(target) < len(arr2):
            target = '0' + target
        _arr2.append(target)

    result = []

    for i in range(len(_arr1)):
        temp = ''
        for j in range(len(_arr1[0])):
            if _arr1[i][j] == _arr2[i][j] == '0':
                temp += ' '
            else:
                temp += '#'
        result.append(temp)

    return result