def solution(myString, pat):
    answer = 0
    string = ""
    for m in myString:
        if m=="A": string+="B"
        else: string+="A"
    if pat in string: return 1
    return answer