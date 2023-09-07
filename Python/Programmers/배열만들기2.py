def solution(l, r):
    answer = []
    for i in range(l,r+1):
        if str(i).replace("0","").replace("5","")=="":
            answer.append(i)
    if not answer: answer = [-1]
    return answer