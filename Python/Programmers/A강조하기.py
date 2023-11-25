def solution(myString):
    answer = ''
    for s in myString:
        if s.lower()=="a": answer+= 'A'
        else: answer+= s.lower()
    return answer