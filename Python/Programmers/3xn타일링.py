# def solution(n):
#     answer = 0
#     f = 0
    
#     if n%2 != 0: return 0

#     if n/4 > 0: f = int(n/4)
    
#     for i in range(f+1):
#         answer += i*2
#         if (n-i*4)!=0 : answer += 3**((n-i*4)/2)
#     return answer

def solution(n):
    answer = [0,3,11]
    idx = int(n/2)
    
    if n%2 != 0: return 0
    if idx<3: return answer[idx]
    
    for i in range(3,idx+1):
        answer.append((3*answer[i-1] + sum(answer[1:i-1])*2+2)%1000000007)
        
    return answer[idx]

# 참고 사이트 : https://s2choco.tistory.com/24