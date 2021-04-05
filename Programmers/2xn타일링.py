def solution(n):
    a, b = 1,1
    for i in range(n):
        a, b = b, a+b
    answer = a % 1000000007
    
#     answer = 0
#     a,b = 0,0
#     lists = []
    
#     for i in range(30000):
#         if a*2 <= n:
#             b = n-2*a
#             a_list = [2 for _ in range(a)]
#             b_list = [1 for _ in range(b)]
#             lists.append(a_list+b_list)
#         else: break
#         a += 1
        
#     for l in lists:
#         if len(set(l))==1:
#             answer += 1
#         else:
#             import itertools
#             event = set(list(itertools.permutations(l, 3)))
#             answer += len(event)
            
    return answer