# def solution(m, n, board):
#     answer = 0
#     remain = [[0]*m for _ in range(n)]
#     board = [list(b) for b in board]
    
#     while True:
#         delete = 1
#         for i in range(m-1):
#             for j in range(n-1):
#                 if board[i][j]==board[i+1][j+1] and board[i][j]==board[i+1][j] and board[i][j]==board[i][j+1]:
#                     remain[i][j]=1
#                     remain[i+1][j+1]=1
#                     remain[i+1][j+1]=1
#                     remain[i+1][j]=1
#                     delete=0
#         if delete: break

#         while True:
#             change=1
#             for i in range(m-1):
#                 for j in range(n-1):
#                     if remain[j][i]==1:
#                         board[j][i]=board[j-1][i]
#                         board[j-1][i]="0"
#                         change=0
#             if change: break
#     return answer

def check(m,n,board):
    filter = [[0 for _ in range(n)] for _ in range(m)]
    count = 0
    
    for i in range(m-1):
        for j in range(n-1):
            if board[i][j]==board[i][j+1]==board[i+1][j]==board[i+1][j+1] and board[i][j]!='0':
                filter[i][j],filter[i][j+1],filter[i+1][j],filter[i+1][j+1] = 1,1,1,1
    
    for i in range(m):
        for j in range(n):
            if filter[i][j]==1:
                count += 1
                board[i][j]='0'
    
    if count==0: return 0

    for i in range(m-2,-1,-1):
        for j in range(n):
            k=i
            # 밑에 내려가는 경우
            while 0<=k+1<m and board[k+1][j]=='0':
                k+=1 # 내려갈 수 있을만큼 갱신
            if k!=i:
                board[k][j] = board[i][j]
                board[i][j] = '0'
                
    return count
    
def solution(m,n,board):
    answer = 0
    board = list(map(list,board))
    
    while True:
        temp = check(m,n,board)
        if temp==0: break
        answer += temp
    return answer

# 참고 사이트 : https://hoons-dev.tistory.com/49