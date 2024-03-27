# from itertools import permutations

# def solution(n, k):
#     peo = [i for i in range(1,n+1)]
#     plist = list(permutations(peo,n))
#     plist.sort()
#     return list(plist[k-1])


import math

def solution(n, k):
    answer = []
    peo = [i for i in range(1,n+1)]
    k-=1
    
    while peo:
        p = k//math.factorial(n-1)
        answer.append(peo[p])
        del peo[p]
        
        k %= math.factorial(n-1)
        n-=1
    return answer