def solution(n,a,b):
    answer = 0

    while a!=b:
        a = (a+1)//2
        b = (b+1)//2
        answer += 1
        
    # import math
    # while (b-a) != 1:
    #     b = math.ceil(b/2)
    #     a = math.ceil(a/2)
    #     answer += 1
    # answer += 1 
    return answer

# 참고 사이트 : https://jjingho.tistory.com/27