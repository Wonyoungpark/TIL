def solution(n):
    answer = 0
    binary = format(n,'b')
    cnt = binary.count('1')
    m = n
    
    while True:
        m+=1
        if cnt == (format(m,'b').count('1')): break
    answer = m
    return answer