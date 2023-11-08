def solution(a, b, c, d):
    lists = [a,b,c,d]
    dice = set(lists)
    length = len(dice)
    dl = list(dice)
    
    if length==1: return 1111*a
    elif length==2:
        cnt = lists.count(dl[0])
        if cnt==3: return (10*dl[0]+dl[1])**2
        elif cnt==2: return (dl[0]+dl[1])*abs(dl[0]-dl[1])
        else: return (10*dl[1]+dl[0])**2
    elif length==3:
        if lists.count(dl[0])==2: return dl[1]*dl[2]
        elif lists.count(dl[1])==2: return dl[0]*dl[2]
        else: return dl[0]*dl[1]
    else: return min(a,b,c,d)