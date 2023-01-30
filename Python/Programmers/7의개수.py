def solution(array):
    answer = 0
    
    for a in array:
        a = str(a)
        b = a.count('7')
        answer += b
    return answer