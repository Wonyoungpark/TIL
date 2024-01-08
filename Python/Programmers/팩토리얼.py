def solution(n):
    answer = 0
    tmp = 1
    
    if n==1: return n

    while n>tmp:
        answer+=1
        tmp*=answer
        if tmp>n: return answer-1
    return answer