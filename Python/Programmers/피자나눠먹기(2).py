def GCD(x,y):
    while y:
        x,y = y, x%y
    return x

def LCM(x,y):
    result = (x*y)//GCD(x,y)
    return result

def solution(n):
    answer = LCM(n,6)/6
    return answer