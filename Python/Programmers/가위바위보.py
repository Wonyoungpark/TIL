def solution(rsp):
    answer = ''
    for r in rsp:
        if r=='2': answer += '0'
        elif r=='5': answer += '2'
        elif r=='0': answer += '5'
    return answer