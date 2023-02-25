def solution(k, ranges):
    answer = []
    klist = [k]
    ks = []
    
    # 우박수열
    while k>1:
        if k%2==0:
            k/=2
        else:
            k = k*3+1
        klist.append(k)
    
    # 구간 넓이
    for i in range(1,len(klist)):
        ks.append((klist[i]+klist[i-1])/2)
        
    for s,e in ranges:
        e += len(ks)
        if s==e: answer.append(0.0)
        elif s>e: answer.append(-1.0)
        else: answer.append(sum(ks[s:e]))
    return answer

# 참고 사이트 : https://arca.live/b/programmer/64018710?p=1