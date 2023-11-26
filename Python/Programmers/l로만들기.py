def solution(myString):
    answer = ''
    for m in myString:
        if m<'l': answer += 'l'
        else: answer += m
    return answer