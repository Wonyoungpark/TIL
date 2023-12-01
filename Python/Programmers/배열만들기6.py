def solution(arr):
    stk = []
    
    for i in range(len(arr)):
        if stk==[]: stk.append(arr[i])
        elif stk[-1]==arr[i]: stk.pop(-1)
        else: stk.append(arr[i])
    if stk==[]: return [-1]
    return stk