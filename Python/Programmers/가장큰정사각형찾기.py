def solution(board):
    answer = 0
    row = len(board)
    col = len(board[0])
    
    for r in range(1,row):
        for c in range(1,col):
            if board[r][c] == 1:
                board[r][c] = min(board[r-1][c-1],board[r-1][c],board[r][c-1]) + 1
                
    for i in range(row):
        temp = max(board[i])
        answer = max(answer,temp)

    return answer**2

# 참고 사이트 : https://velog.io/@ju_h2/Python-프로그래머스-level2-가장-큰-정사각형-찾기-동적-프로그래밍-dp