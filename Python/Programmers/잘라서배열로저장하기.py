import math

def solution(my_str, n):
    answer = []
    cnt = math.ceil(len(my_str)/n)
    c = 0
    
    while(c!=cnt):
        answer.append(my_str[c*n:(c+1)*n])
        c+=1
        
    return answer