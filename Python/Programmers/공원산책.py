# import re
# def solution(park, routes):
#     answer = []
#     H = len(park)
#     W = len(park[0])
#     dx = [0,1,0,-1]
#     dy = [1,0,-1,0] # E,S,W,N
#     no = []
    
#     for e,length in enumerate(park):
#         s = length.find("S")
#         x = [[e,i] for i,x in enumerate(length) if x=="X"]
#         if s!=-1: start = [e,s]
#         if x: no.extend(x)
    
#     for route in routes:
#         route = route.split()
#         if route[0]=="E": d = 0
#         elif route[0]=="S": d = 1
#         elif route[0]=="W": d = 2
#         else: d = 3
#         x = start[0]+dx[d]*int(route[1])
#         y = start[1]+dy[d]*int(route[1])
        
#         go = True
#         for n in no:
#             if start[0]==x:
#                 if start<=n<=[x,y]:
#                     go=False
#             elif start[1]==y:
#                 if start<=n<=[x,y]:
#                     go=False
#         if (0<=x<=(H-1) and 0<=y<=(W-1)) and go:
#             start = [x,y]
#     return start

def solution(park,routes):
    x,y = 0,0
    w,h = len(park[0]),len(park)
    op = {"N":(-1,0), "S":(1,0), "W":(0,-1), "E":(0,1)}
    
    for i in range(h):
        for j in range(w):
            if park[i][j]=="S":
                x,y = i,j
                break
                
    for r in routes:
        d,n = r.split()
        dx,dy = x,y
        
        for i in range(int(n)):
            nx = x+op[d][0]
            ny = y+op[d][1]
            if (0<=nx<=h-1) and (0<=ny<=w-1) and (park[nx][ny]!="X"):
                x,y = nx,ny
            else:
                x,y = dx,dy
                break
    return (x,y)