def solution(common):
    answer = 0
    length = len(common)
    r = common[1]-common[0]
    
    # 공차인 경우
    for l in range(1, length-1):
        if r == common[l+1]-common[l]: continue
        # 공비인 경우
        else:
            r = common[1]/common[0]
            answer = common[-1]*r
            return answer
    answer = common[-1]+r
    
    return answer