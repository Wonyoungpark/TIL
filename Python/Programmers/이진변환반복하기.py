def solution(s):
    answer = [0,0]
    
    while(s.count("1")>1 or s.count("0")>0):
        tmp = s.replace("0","")
        change = bin(len(tmp))[2:]
        answer[1] += len(s)-len(tmp)
        s = change
        answer[0] += 1
    return answer