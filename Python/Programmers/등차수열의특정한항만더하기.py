def solution(a, d, included):
    answer = 0
    for e,i in enumerate(included):
        if i: answer += a+d*e
    return answer