def solution(n):
    answer = 0
    result = []
    
    while n >= 1:
        result.append(n % 3)
        n = n // 3
    
    result.reverse()
    
    import math
    for i in range(len(result)):
        answer += result[i]*math.pow(3,i)
    return answer