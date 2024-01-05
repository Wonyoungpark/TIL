def solution(n):
    answer = [[0]*n for _ in range(n)]
    mode = 1 # 방향키
    x,y = 0,0
    
    if n==1: return [[1]]

    for i in range(n*n):
        answer[x][y] = i+1
        if mode%4==1: #오른쪽
            y+=1 #오른쪽 한칸 이동
            #마지막 칸이거나 값이 이미 있으면 방향 변경
            if y==n-1 or answer[x][y+1]!=0: mode+=1
        elif mode%4==2: #아래
            x+=1 #아래 한칸 이동
            if x==n-1 or answer[x+1][y]!=0: mode+=1
        elif mode%4==3: #왼쪽
            y-=1 #왼쪽 한칸 이동
            if y==n-1 or answer[x][y-1]!=0: mode+=1
        elif mode%4==0:
            x-=1 #위로 한칸 이동
            if x==n-1 or answer[x-1][y]!=0: mode+=1
    return answer


# 참고 : https://velog.io/@poooq/프로그래머스python-정수를-나선형으로-배치하기