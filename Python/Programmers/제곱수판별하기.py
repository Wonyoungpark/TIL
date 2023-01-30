import math

def solution(n):
    n = math.sqrt(n)
    if n.is_integer(): return 1
    else: return 2