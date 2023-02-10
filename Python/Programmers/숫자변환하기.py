# import sys
# sys.setrecursionlimit(10**6)

# def plus(x,y,n,cnt):
#     if x<y:
#         x += n
#         cnt += 1
#         return plus(x,y,n,cnt)
#     elif x==y: return cnt
#     else: return 0
    
# def mult2(x,y,cnt):
#     if x<y:
#         x*=2
#         cnt+=1
#         return mult2(x,y,cnt)
#     elif x==y: return cnt
#     else: return 0

# def mult3(x,y,cnt):
#     if x<y:
#         x*=3
#         cnt+=1
#         return mult3(x,y,cnt)
#     elif x==y: return cnt
#     else: return 0

# def solution(x, y, n):
#     answer = 0
#     cnt = 0
    
#     if x==y: return 0
#     result = [plus(x,y,n,cnt),mult2(x,y,cnt),mult3(x,y,cnt)]
#     result = list(set(result))
#     result.remove(0)
#     if result: answer = result[0]
#     else: answer = -1
    
#     return answer

from collections import deque

def solution(x,y,n):
    dis = [0 for _ in range(y+1)]
    Q = deque()
    Q.append(x)
    
    if x==y: return 0
    
    while Q:
        nx = Q.popleft()
        for dir in range(3):
            if dir == 0: cur_x = nx*2
            if dir == 1: cur_x = nx*3
            if dir == 2: cur_x = nx+n
            if cur_x>y or dis[cur_x]: continue
            if cur_x == y: return dis[nx]+1
            Q.append(cur_x)
            dis[cur_x] = dis[nx]+1
            
    return -1

# 참고 사이트 : https://americanoisice.tistory.com/196