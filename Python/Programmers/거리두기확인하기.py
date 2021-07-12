from collections import deque

d = ((0,1),(1,0),(-1,0),(0,-1))
SIZE = 5

def make_maps(place):
    arr = []
    men = []
    for i, string in enumerate(place):
        for j, ch in enumerate(string):
            if ch=="P": men.append((i,j))
        arr.append(list(string))
    return arr, men

def is_in(y,x):
    if -1<y<SIZE and -1<x<SIZE: return True
    return False

def bfs(arr,sy,sx):
    q = deque()
    q.append((sy,sx))
    table = [[-1 for _ in range(SIZE)] for _ in range(SIZE)]
    table[sy][sx] = 0
    
    while q:
        y,x = q.popleft()
        
        for dy,dx in d:
            ny = y+dy
            nx = x+dx
            
            if not is_in(ny,nx): continue
            if arr[ny][nx] != "X" and table[ny][nx]==-1:
                table[ny][nx] = table[y][x] + 1
                q.append((ny,nx))
    return table

def solution(places):
    answer = []
    
    for place in places:
        arr,men = make_maps(place)
        ok = True
        
        for man in men:
            table = bfs(arr,man[0],man[1])
            for other_man in men:
                if man != other_man:
                    y = other_man[0]
                    x = other_man[1]
                    if -1<table[y][x]<=2:
                        ok = False
                        break
            if not ok: break
                
        if ok:
            answer.append(1)
        else:
            answer.append(0)
    
#     place = places[0]
#     stack = []
#     for r in range(5):
#         for c in range(5):
#             if place[r][c]=="P":
#                 stack.append([r,c])
    
#     number = [i for i in range(len(stack))]
#     from itertools import combinations
#     nlist = list(combinations(number,2))
#     for i in nlist:
#         manhat = abs(stack[i[0]][0]-stack[i[1]][0]) + abs(stack[i[0]][1]-stack[i[1]][1])
#         if(manhat<=2):
#             for q in range(stack[i[0]][0],stack[i[1]][0]+1):
#                 for t in range(stack[i[0]][1],stack[i[1]][1]+1):
#                     print(place[q][t])
    return answer

# 참고 사이트 : https://velog.io/@study-dev347/프로그래머스-거리두기-확인하기