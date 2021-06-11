def solution(a, b):
    answer = 0
    for i in zip(a,b):
        answer += i[0]*i[1]
    return answer