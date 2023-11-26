def solution(myString, pat):
    answer = 0
    length = len(pat)
    for m in range(len(myString)):
        if myString[m:m+length]==pat: answer+=1
    return answer