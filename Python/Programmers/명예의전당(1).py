def solution(k, score):
    answer = []
    reput = []
    for s in score:
        reput.append(s)
        reput.sort()
        if len(reput)>k:
            reput.pop(0)
        answer.append(reput[0])
    return answer