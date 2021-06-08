def solution(rows, columns, queries):
    answer = []
    board = [ [0 for i in range(columns)] for _ in range(rows)]
    n = 1
    for j in range(rows):
        for i in range(columns):
            board[j][i] = n
            n += 1
    
    for x1,y1,x2,y2 in queries:
        tmp = board[x1-1][y1-1]
        small = tmp
        
        for k in range(x1-1,x2-1): # 행 +1
            test = board[k+1][y1-1]
            board[k][y1-1] = test
            small = min(small, test)
            
        for k in range(y1-1,y2-1): # 열 +1
            test = board[x2-1][k+1]
            board[x2-1][k] = test
            small = min(small, test)
            
        for k in range(x2-1,x1-1,-1): # 행 -1
            test = board[k-1][y2-1]
            board[k][y2-1] = test
            small = min(small, test)
            
        for k in range(y2-1,y1-1,-1): # 열 -1
            test = board[x1-1][k-1]
            board[x1-1][k] = test
            small = min(small, test)
        
        board[x1-1][y1] = tmp
        answer.append(small)
        
    return answer

    # 참고 사이트 : https://minnit-develop.tistory.com/23