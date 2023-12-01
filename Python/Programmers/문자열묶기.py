def solution(strArr):
    answer = []
    for s in strArr: answer.append(len(s))
    cnt = 0
    for a in list(set(answer)):
        if answer.count(a)>cnt: cnt = answer.count(a)
    return cnt