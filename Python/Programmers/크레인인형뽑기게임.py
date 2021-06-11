def solution(board, moves):
    bucket = []
    answer = []
    for move in moves:
        for i in range(len(board)):
            if board[i][move-1] > 0:
                bucket.append(board[i][move-1])
                board[i][move-1] = 0
                if bucket[-1:] == bucket[-2:-1]:
                    answer += bucket[-1:]
                    bucket = bucket[:-2]
                break
    return len(answer)*2



# def solution(board, moves):
#     # answer = 0
#     pop_list = []
    
#     for tar in moves:
#         for row in board:
#             target = row[tar-1]
#             if target != 0:
#                 pop_list.append(target)
#                 row[tar-1] = 0
#                 break
    
#     answer = pop(pop_list)
#     return answer

# def pop(pop_list):
#     p = 0
#     while(p < len(pop_list)):
#         if p+1 == len(pop_list):
#             continue
#         if pop_list[p] == pop_list[p+1]:
#             del pop_list[p]
#             del pop_list[p+1]
#             pop(pop_list)
#             print(pop_list)
#         p+=1
#     return len(pop_list)