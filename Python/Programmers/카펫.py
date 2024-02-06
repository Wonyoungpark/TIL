def solution(brown, yellow):
    answer = []
    sums = brown+yellow
    ylist = []
    for i in range(1,(yellow+1)):
        if yellow%i==0:
            ylist.append((i, yellow//i))
            
    ylist = ylist[len(ylist)//2:]
    for a,b in ylist:
        if sums==(a+2)*(b+2): return [(a+2),(b+2)]
    return answer