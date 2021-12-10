def solution(n, arr1, arr2):
    answer = []
    for a,b in zip(arr1,arr2):
        v = format((a|b),'b')
        if (len(v)!=n):
            v=('0'*(n-len(v)))+v
        v = v.replace("1","#")
        v = v.replace("0"," ")
        answer.append(v)
    return answer