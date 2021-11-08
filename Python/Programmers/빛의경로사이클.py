import sys
sys.setrecursionlimit(10**6) # 재귀함수 이용 범위

def out(x,y,d,grid,dic): # 방향 따른 x,y 변화
    nx = x + dic[d][0]
    ny = y + dic[d][1]
    
    if nx>=len(grid): nx=0 # 아래
    elif nx<0: nx=len(grid)-1 # 위
    if ny>=len(grid[0]): ny=0 # 오른쪽
    elif ny<0: ny=len(grid[0])-1 # 왼쪽
        
    return nx, ny

def dfs(state,org,route,grid):
    dic = {0:[-1,0], 1:[0,1], 2:[1,0], 3:[0,-1]} # 방향: 아래쪽,왼쪽,위쪽,오른쪽
    x = state[0]
    y = state[1]
    d = state[2]
    visited[d][x][y] = 1 # 방문 표시
    
    nx,ny = out(x,y,d,grid,dic) # 좌표 업데이트
    value = grid[nx][ny]
    
    # 방향별 회전
    if value=='R': d = (d+5)%4
    elif value=='L': d = (d+7)%4
        
    # 첫 노드와 사이클인지 확인
    if org[0]==nx and org[1]==ny and org[2]==d:
        answer.append(route)
        return
    if not visited[d][nx][ny]: # 미방문 노드가 있을 경우
        dfs([nx,ny,d],org,route+1,grid)

def solution(grid):
    global answer, visited
    answer = []
    visited = [[[0]*len(grid[0]) for _ in range(len(grid))] for _ in range(4)] # 행*열*방향
    
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            for d in range(4): # 4 방향
                dfs([i,j,d],[i,j,d],1,grid)
    return sorted(answer)

# 참고 사이트 : https://moondol-ai.tistory.com/433