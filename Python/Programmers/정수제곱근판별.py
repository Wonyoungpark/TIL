def solution(n):
    answer = 0
    num = n**0.5
    if (num.is_integer()): answer=(num+1)**2
    else: answer = -1
    return answer