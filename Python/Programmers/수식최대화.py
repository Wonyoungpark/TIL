def calculation(oper,n,expression):
    if n == 2:
        return str(eval(expression))
    if oper[n] == "*":
        res = eval('*'.join([calculation(oper,n+1,e) for e in expression.split(
"*")]))
    if oper[n] == "+":
        res = eval('+'.join([calculation(oper,n+1,e) for e in expression.split(
"+")]))
    if oper[n] == "-":
        res = eval('-'.join([calculation(oper,n+1,e) for e in expression.split(
"-")]))
    return str(res)
    
    
def solution(expression):
    answer = 0
    oper = ["+","-","*"]
    from itertools import permutations
    order_oper = list(permutations(oper,len(oper)))
    
    for o in order_oper:
        result = int(calculation(o,0,expression))
        answer = max(answer, abs(result))
        
    return answer

    # 참고 사이트 : https://soniacomp.medium.com/카카오-수식최대화-파이썬-2020-카카오-인턴십-문제-풀이-e43e53ae19b6