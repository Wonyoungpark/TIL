from collections import deque

def bfs(maps,start,end):
    visited = [[0]*1000 for _ in range(1000)]
    drs,dcs = [0,0,1,-1], [1,-1,0,0]
    queue = deque()
    queue.append(start)
    
    while len(queue):
        r,c,dist = queue.popleft()
        if not(0<=r<len(maps)) or not(0<=c<len(maps[0])): continue
        if maps[r][c]=='X' or visited[r][c]==True: continue
        if maps[r][c]==maps[end[0]][end[1]]: return dist
        
        visited[r][c] = True
        
        for dr,dc in zip(drs,dcs):
            if 0<=r+dr<len(maps) and 0<=c+dc<len(maps[0]):
                if maps[r+dr][c+dc]!='X' and visited[r+dr][c+dc]==False:
                    queue.append((r+dr,c+dc,dist+1))
    
    return -1
    
def solution(maps):
    start,lever,end = 0,0,0
    
    for r in range(len(maps)):
        for c in range(len(maps[0])):
            if maps[r][c]=='S': start = r,c,0
            if maps[r][c]=='L': lever = r,c,0
            if maps[r][c]=='E': end = r,c,0
    
    first,second = bfs(maps,start,lever), bfs(maps,lever,end)
    if -1 in [first,second]: return -1

    return first+second

# 참고 사이트 : https://school.programmers.co.kr/learn/courses/30/lessons/159993/solution_groups?language=python3