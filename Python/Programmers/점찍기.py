import math

def solution(k, d):
    answer = 0
    
    for i in range(0,d+1,k):
        result = math.floor(math.sqrt(d**2 - i**2)) # 피타고라스
        # 배수만 채택
        answer += (result//k)+1 # +1은 0 포함을 위해
    return answer

# 참고 사이트 : https://codingbutterfly.tistory.com/66