def solution(dartResult):
    num = ''
    stack = []
    
    for dr in dartResult:
        if(dr.isdigit()): num += dr
        elif dr =="S":
            num = int(num)
            stack.append(num)
            num = ''
        elif dr =="D":
            num = int(num)**2
            stack.append(num)
            num = ''
        elif dr =="T":
            num = int(num)**3
            stack.append(num)
            num = ''
        elif dr =="*":
            if len(stack)>1:
                stack[-2] *=2
                stack[-1] *=2
            else: stack[-1]*=2
        else:
            stack[-1]*=-1
    return sum(stack)

# 참고 사이트 : https://velog.io/@godiva7319/프로그래머스-Level1-1차-다트-게임-Python