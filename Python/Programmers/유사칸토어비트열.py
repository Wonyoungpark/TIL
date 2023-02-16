# import sys
# sys.setrecursionlimit(10**9)

# def cantor(n,string):
#     canto = ''
#     if n == 0: return '1'
#     else:
#         for c in string:
#             if c == '1': canto += '11011'
#             else: canto += '00000'
#     return canto
    
# def solution(n, l, r):
#     answer = 0
#     string = ''
    
#     for i in range(n+1):
#         string = (cantor(i,string))
    
#     answer = string[l-1:r].count('1')    
    
#     return answer

def solution(n, l, r):
    answer = r-(l-1)
    
    for num in range(l-1,r):
        while num>=1:
            a,b = divmod(num,5) # 몫, 나머지
            if b==2 or a==2: # 5진수 비트열이 0이 될 경우
                answer -= 1
                break
            num = a

    return answer