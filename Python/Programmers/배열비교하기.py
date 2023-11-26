def solution(arr1, arr2):
    a1 = len(arr1)
    a2 = len(arr2)
    if a1>a2: return 1
    elif a1<a2: return -1
    else:
        s1 = sum(arr1)
        s2 = sum(arr2)
        if s1>s2: return 1
        elif s1<s2: return -1
        else: return 0