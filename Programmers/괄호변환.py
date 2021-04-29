def divide_str(p):
    count = [0,0]
    for i in p:
        if i == '(':
            count[0] += 1
        else:
            count[1] += 1
        if count[0] == count[1]:
            break
    return p[:sum(count)], p[sum(count):]

 
def right_str(p):
    stack = []
    
    try:
        for i in p:
            if i == '(': stack.append(i)
            else: stack.pop()
        return True
    except:
        return False
    

def convert_str(u):
    stack = ''
    for i in u:
        if i == '(': stack += ')'
        else: stack += '('
    return stack
    
    
def solution(p):
    answer = ''
    
    while len(p) != 0:
        u, p = divide_str(p)
        if right_str(u):
            answer += u
        else:
            answer += '(' + solution(p) + ')' + convert_str(u[1:-1])
            break
    return answer

    # 참고 : https://johnyejin.tistory.com/124