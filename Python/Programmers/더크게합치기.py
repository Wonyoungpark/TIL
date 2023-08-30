def solution(a, b):
    answer = 0
    first = int(str(a)+str(b))
    second = int(str(b)+str(a))
    if first>=second: answer = first
    else: answer = second
    return answer