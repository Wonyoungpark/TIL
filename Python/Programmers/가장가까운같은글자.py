def solution(s):
    str = list(s)
    answer = []
    for e,s in enumerate(str):
        new = str[:e]
        if not (s in new): answer.append(-1)
        else:
            answer.append(new[::-1].index(s)+1)
    return answer