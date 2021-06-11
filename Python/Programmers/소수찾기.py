from itertools import permutations

def solution(n):
    a = set()
    for i in range(len(n)):
        a |= set(map(int,map("".join,permutations(list(n), i+1))))
    a -= set(range(0,2))
    
    for i in range(2,int(max(a)**0.5)+1):
        a -= set(range(i*2,max(a)+1,i))
    return len(a)
    
#     answers = 0
#     strings = []
#     nums = []
#     for string in numbers:
#         strings.append(string)
#     for i in range(1, len(strings)+1):
#         nums.extend(list(map(''.join, permutations(strings, i))))
#     nums = list(set(nums))
#     for n in nums:
#         n = int(n)
        
#         if n >= 2:
#             for i in range(2, n):
#                 if n % i == 0:
#                     break

    return answer    