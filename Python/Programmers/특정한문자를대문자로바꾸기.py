def solution(my_string, alp):
    answer = ''
    for m in my_string:
        if alp==m: answer+=m.upper()
        else: answer += m
    return answer