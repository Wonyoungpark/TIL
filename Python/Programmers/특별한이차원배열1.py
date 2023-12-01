def solution(n):
    answer = []
    for i in range(n):
        mid = []
        for j in range(n):
            if i==j: mid.append(1)
            else: mid.append(0)
        answer.append(mid)
    return answer