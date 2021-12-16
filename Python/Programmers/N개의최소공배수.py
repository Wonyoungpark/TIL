def solution(arr):
    # answer = 1
    # number = []
    # for a in arr:
    #     for i in range(1,a+1):
    #         if a%i==0:
    #             number.append(i)
    # number = list(set(number))
    
    # for j in reversed(number):
    #     for n in number:
    #         if(j%n==0):
    #             number.remove(n)
    
    # for n in number:
    #     if answer%n!=0:
    #         answer*=n

    from math import gcd

    answer = arr[0]
    for n in arr:
        answer = answer*n // gcd(answer,n)
    return answer

# 참고 사이트 : https://velog.io/@insutance/프로그래머스Python-N개의-최소공배수