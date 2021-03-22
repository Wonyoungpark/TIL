def solution(s):
    answer = []
    
    for i in s:
        if '(' in answer and i == ')':
            answer.pop()
        else:
            answer.append(i)
    if not answer:
        return True
    else:
        return False