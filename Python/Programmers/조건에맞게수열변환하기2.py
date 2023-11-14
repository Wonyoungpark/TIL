def solution(arr):
    prev = []
    answer = 0
    
    while prev != arr:
        prev = arr.copy()
        for i in range(len(arr)):
            if arr[i]>=50 and arr[i]%2==0: arr[i] /=2
            elif arr[i]<50 and arr[i]%2==1: arr[i] = arr[i]*2+1
        answer+=1
    return answer-1