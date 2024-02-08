import math

def solution(n):
    if n==1: return 1 % 1234567
    elif n==2: return 2 % 1234567
    else:
        a,b=1,2
        for i in range(n-2): a,b = b,a+b #피보나치 수열 4=3+1, 3=2+1...
        return b % 1234567