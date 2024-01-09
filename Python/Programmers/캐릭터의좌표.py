def solution(keyinput, board):
    limit = [board[0]//2,board[1]//2]
    direc = {"up":(0,1),"down":(0,-1),"left":(-1,0),"right":(1,0)}
    x,y = 0,0
    
    for key in keyinput:
        dx,dy = direc[key]
        if abs(x+dx)>limit[0] or abs(y+dy)>limit[1]: continue
        else: x,y = x+dx, y+dy
    return [x,y]

# 참고 사이트 : https://velog.io/@8essong30/알고리즘-프로그래머스-캐릭터-좌표