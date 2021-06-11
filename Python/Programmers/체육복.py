def solution(n, lost, reserve):
    r_lost = set(lost) - set(reserve)
    l_reserve = set(reserve) - set(lost)
    
    for i in l_reserve:
        if i-1 in r_lost:
            r_lost.remove(i-1)
        elif i+1 in r_lost:
            r_lost.remove(i+1)
            
    return n - len(r_lost)
    
#     answer = n - len(lost)
    
#     # 여벌 학생이 도난당할 경우
#     for j in lost:
#         if j in reserve:
#             reserve.remove(j)
#             lost.remove(j)
#             answer += 1
                  
#     for j in lost:
#         if j-1 in reserve:
#             reserve.remove(j-1)
#             lost.remove(j)
#             answer += 1
            
#     for j in lost:
#         if j+1 in reserve:
#             reserve.remove(j+1)
#             lost.remove(j)
#             answer += 1

#     return answer