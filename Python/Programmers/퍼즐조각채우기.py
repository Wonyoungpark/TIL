# 블록 저장 함수
def dfs(i,j,board,visited,empty,n):
    section = []
    stack = [(i,j)]
    while stack:
        x, y = stack.pop()
        if x>=0 and y>=0:
            try:
                if visited[x][y] == False and board[x][y] == n:
                    visited[x][y] = True
                    section.append((x,y))
                    
                    stack.append((x-1,y))
                    stack.append((x+1,y))
                    stack.append((x,y-1))
                    stack.append((x,y+1))
            except IndexError: continue
    empty.append(sorted(section))
    
# 블록 위치를 (0,0) 변경
def standard_z(b):
    temp = []
    stdx = b[0][0]
    stdy = b[0][1]
    for x,y in b:
        temp.append((x-stdx,y-stdy))
    return sorted(temp)
                        
def solution(game_board, table):
    answer = []
    N = len(game_board)
    
    visited_board = [list(False for _ in range(N)) for _ in range(N)]
    empty_board = [] # game_board의 빈자리 좌표
    visited_table = [list(False for _ in range(N)) for _ in range(N)]
    block_table = [] # table의 블록 좌표
    
    # game_board의 빈자리 empty_board에 할당
    for i in range(N):
        for j in range(N):
            if visited_board[i][j] == False and game_board[i][j] == 0:
                dfs(i,j,game_board,visited_board,empty_board,0)
    # table의 블록 block_table 할당
    for i in range(N):
        for j in range(N):
            if visited_table[i][j] == False and table[i][j] == 1:
                dfs(i,j,table,visited_table,block_table,1)
    
    # block_table의 블록을 (0,0) 기준으로 변경
    blocks = []
    for block in block_table:
        blocks.append(standard_z(block))
    
    
    # 블록 자리 찾기
    def match(block):
        for x in range(N):
            for y in range(N):
                move = []
                for i,j in block:
                    new_x = x+i
                    new_y = y+j
                    if new_x>=0 and new_y>=0:
                        try:
                            _ = game_board[x+i][y+j]
                            move.append((x+i,y+j))
                        except IndexError: break
                    else: break
                if len(block) == len(move) and move in empty_board: # 블록 자리 찾음
                    empty_board.remove(move)
                    answer.extend(move)
                    return True
        return False

    # 블록 회전
    def rotate(block):
        new = []
        for x,y in block:
            new.append((y,N-1-x))
        return standard_z(new)
    
    # 블록 자리 찾기
    for block in blocks:
        for _ in range(4):
            if match(block) == False:
                block = rotate(block)
            else: break
    return len(answer)

# 참고 사이트 : https://ye333.tistory.com/m/163