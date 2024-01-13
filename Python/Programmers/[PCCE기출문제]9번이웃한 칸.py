def solution(board, h, w):
    answer = 0
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]
    l = len(board)
    
    for x,y in zip(dx,dy):
        xh = x+h
        yw = y+w
        if xh>=0 and xh<l and yw>=0 and yw<l:
            if board[xh][yw]==board[h][w]: answer += 1
    return answer