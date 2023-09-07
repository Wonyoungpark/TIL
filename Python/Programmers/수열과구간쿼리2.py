def solution(arr, queries):
    answer = []
    for [s,e,k] in queries:
        res = []
        for a in range(s,e+1):
            if arr[a]>k:
                res.append(arr[a])
        if res: answer.append(min(res))
        else: answer.append(-1)
    return answer