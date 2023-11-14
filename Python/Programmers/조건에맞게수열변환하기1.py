def solution(arr):
    for a in range(len(arr)):
        if arr[a]>=50 and arr[a]%2==0: arr[a] /= 2
        elif arr[a]<50 and arr[a]%2==1: arr[a] *= 2
    return arr