def solution(arr, k):
    if k%2==1: answer = [a*k for a in arr]
    else: answer= [a+k for a in arr]
    return answer