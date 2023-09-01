def solution(code):
    answer = ''
    mode = 0
    for e,c in enumerate(code):
        if c=="1": mode = not mode
        else:
            if mode:
                if e%2!=0: answer += c
            else:
                if e%2==0: answer += c
    if answer == '': return "EMPTY"
    return answer