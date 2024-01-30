def solution(survey, choices):
    answer = ''
    res = {"R":0,"T":0,"C":0,"F":0,"J":0,"M":0,"A":0,"N":0}
    
    for s,c in zip(survey,choices):
        score = c-4
        if score>0: res[s[1]]+=score
        else: res[s[0]]-=score
    
    answer += "T" if res["R"]<res["T"] else "R"
    answer += "F" if res["C"]<res["F"] else "C"
    answer += "M" if res["J"]<res["M"] else "J"
    answer += "N" if res["A"]<res["N"] else "A"
    return answer