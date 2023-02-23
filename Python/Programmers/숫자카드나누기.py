# import math

# def division(arr):
#     div = []
#     d = False
    
#     for i in range(arr[0],1,-1):
#         for a in arr:
#             if a%i==0:
#                 d = True
#             else:
#                 d = False
#                 break
#         if d ==True:
#             div.append(i)
#     return div

# def solution(arrayA, arrayB):
#     arrayA = sorted(list(set(arrayA)))
#     arrayB = sorted(list(set(arrayB)))
    
#     adiv = division(arrayA)
#     bdiv = division(arrayB)
    
#     for a in adiv:
#         for b in arrayB:
#             if b%a==0: return 0
#         return a

#     for b in bdiv:
#         for a in arrayA:
#             if a%b==0: return 0
#         return b

from math import gcd

def GCD(arr):
    g = arr[0]
    for i in range(1,len(arr)):
        g = gcd(g,arr[i])
    return g

def solution(arrayA,arrayB):
    answer = 0
    arrayA = sorted(list(set(arrayA)))
    arrayB = sorted(list(set(arrayB)))
    
    a,b = GCD(arrayA), GCD(arrayB)
    
    for i in arrayB:
        if i%a==0: break
    else: answer = max(a,answer)
        
    for i in arrayA:
        if i%b==0: break
    else: answer = max(b,answer)
        
    return answer

# 참고 사이트 : https://windy7271.tistory.com/entry/PythonLV2-숫자-카드-나누기