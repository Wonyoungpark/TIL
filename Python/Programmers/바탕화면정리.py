def solution(wallpaper):
    answer = []
    end_h = []
    ws = [0]*len(wallpaper[0])
    
    for i in range(len(wallpaper)):
        wall=wallpaper[i]
        flag = False
        for w in range(len(wall)):
            if wall[w]=="#":
                ws[w]+=1
                flag = True
        if flag: end_h.append(i+1)
        
    answer = [end_h[0]-1,end_h[-1]]
    for w in range(len(ws)):
        if ws[w]!=0:
            answer.insert(1,w)
            break
            
    for w in range(len(ws)-1,-1,-1):
        if ws[w]!=0:
            answer.insert(3,w+1)
            break
    return answer