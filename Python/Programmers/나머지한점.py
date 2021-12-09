def solution(v):
    answer = []
    v.sort()
    if (v[0][0]!=v[1][0]):
        answer.append(v[0][0])
        if v[0][1]!=v[-1][1]:
            answer.append(v[-1][1])
        else:
            answer.append(v[1][1])
    else:
        answer.append(v[2][0])
        if v[0][1]!=v[-1][1]:
            answer.append(v[0][1])
        else:
            answer.append(v[1][1])
    return answer