# import sys
# sys.setrecursionlimit(10**6)

# def solution(numbers):
#     answer = []
    
#     def test(e,i):
#         if e+i > len(numbers)-1: return -1
#         if numbers[e]<numbers[e+i]: return numbers[e+i]
#         else:
#             i+=1
#             return test(e,i)
        
#     for e,n in enumerate(numbers):
#         i = 0
#         answer.append(test(e,i))
        
#     return answer

def solution(numbers):
    answer = [-1]*len(numbers)
    stack = []
    
    for i in range(len(numbers)):
        while stack and numbers[stack[-1]]<numbers[i]:
            answer[stack.pop()] = numbers[i]
        stack.append(i)
        
    return answer

# 참고 사이트 : https://school.programmers.co.kr/questions/43789