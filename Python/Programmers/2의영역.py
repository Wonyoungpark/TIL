def solution(arr):
    answer = []
    start = -1
    end = -1
    for a in range(len(arr)):
        if arr[a]==2:
            if start==-1: start = a
            else:
                end = a
    if start==-1: answer = [-1]
    elif end!=-1: answer = arr[start:end+1]
    else: answer = [2] 
    return answer