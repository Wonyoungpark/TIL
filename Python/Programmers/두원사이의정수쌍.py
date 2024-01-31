from math import sqrt

def solution(r1, r2):
    answer = 0
    
    for i in range(0,r1):
        #축 한 곳에서 큰원-작은원의 개수를 구한다.
        answer += int(sqrt(r2**2-i**2)) - int(sqrt(r1**2-i**2-1))
        
    # 작은원 축 범위 밖의 점 개수
    for i in range(r1,r2):
        answer += int(sqrt(r2**2-i**2))
    return answer*4