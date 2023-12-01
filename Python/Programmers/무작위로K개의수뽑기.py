def solution(arr, k):
    answer = list(dict.fromkeys(arr))
    if k>len(answer):
        for _ in range(k-len(answer)): answer.append(-1)
    elif k<len(answer): answer = answer[:k]
    return answer