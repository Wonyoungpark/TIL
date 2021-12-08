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


def solution(n):
    num_set = set(range(2,n+1))
    
    for i in range(2,n+1):
        if i in num_set:
            num_set -= set(range(i*2,n+1,i))
            
    answer = len(num_set)
    return answer

# def find_n(n):
#     num = [i for i in range(1,n+1) if (n%i)==0 if not (i==1 or i==n)]
#     if (len(num)==0): return n
    
# def solution(n):
#     answer = 0
#     for i in range(2,n+1):
#         if (find_n(i)!=None):
#             answer+=1
#     return answer