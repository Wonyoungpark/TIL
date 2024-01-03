def solution(arr):
    answer = []
    r = len(arr)
    c = len(arr[0])
    if r>c:
        for a in arr:
            a.extend([0]*(r-c))
            answer.append(a)
    elif r<c:
        answer.extend(arr)
        for i in range(c-r):
            answer.append([0]*c)
    else:
        return arr
    return answer