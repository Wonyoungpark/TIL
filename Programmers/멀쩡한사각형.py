import math

def solution(w,h):
    answer = 1
    rate = math.gcd(h,w)
    answer = w*h - (w+h-rate)
    return answer