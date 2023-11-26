def solution(myString, pat):
    answer = ''
    length = len(pat)
    for m in range(len(myString),-1,-1):
        if myString[m-length:m]==pat: return myString[:m]
    return answer