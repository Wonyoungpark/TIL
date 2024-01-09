def solution(n):
    answer = []
    i=2
    while n>=i:
        if n%i==0:
            answer.append(i)
            n/=i
        else: i += 1
    answer = list(set(answer))
    answer.sort()
    return answer