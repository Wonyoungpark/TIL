def solution(a, b):
    answer = 0
    first = int(str(a)+str(b))
    second = 2*a*b
    if first>=second: answer = first
    else: answer = second
    return answer