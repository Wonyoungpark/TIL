def DFS(n, computers, com, visited):
    visited[com] = True
    for connect in range(n):
        if connect != com and computers[com][connect] == 1:
            if visited[connect] == False:
                DFS(n, computers, connect, visited)

def solution(n, computers):
    answer = 0
    
    visited = [False for i in range(n)]
    for com in range(n):
        if visited[com] == False:
            DFS(n, computers, com, visited)
            answer += 1
    return answer
    
#     networks = []
    
#     for i in range(n):
#         for j in range(n):
#             if computers[i][j] == 1 and computers[i][j] == computers[j][i] and [j,i] not in networks:
#                 networks.append([i,j])
    
#     for n in range(len(networks)):
#         if n != len(networks)-1:
#             if (networks[n][1]+1) == networks[n+1][0]:
#                 answer +=1
#     return answer + 1

# 참고 사이트 : https://programmers.co.kr/learn/courses/30/lessons/43162