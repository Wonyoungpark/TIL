def solution(t, p):
    answer = 0
    t_list = [int(t[i:i+len(p)]) for i in range(0,len(t)-len(p)+1)]
    
    for i in t_list:
        if i <= int(p): answer += 1
    return answer