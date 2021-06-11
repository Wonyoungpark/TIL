from collections import deque

d = [[1,0], [-1, 0], [0,1], [0,-1]]

def solution(maps):
    r = len(maps)
    c = len(maps[0])
    table = [[-1 for _ in range(c)] for _ in range(r)]
    q = deque()
    q.append([0,0])
    table[0][0] = 1

    while q:
        y, x = q.popleft()

        for i in range(4):
            ny = y + d[i][0]
            nx = x + d[i][1]

            if -1<ny<r and -1<nx<c:
                if maps[ny][nx] == 1: # 갈 수 있는 길인지
                    if table[ny][nx] == -1: # 아직 방문하지 않은 노드인지
                        table[ny][nx] = table[y][x] + 1 # 방문처리
                        q.append([ny, nx])

    answer = table[-1][-1]
    return answer


# def solution(maps):
#     answer = 0
#     i, j = 0, 0
#     state = [[0,0]]
    
#     for _ in range(10):
#         if maps[i+1][j] == 1 & ([i+1,j] not in state):
#             i += 1
#             answer += 1
#             state.append([i,j])
#             print("down")
#         elif maps[i][j+1] == 1 & ([i,j+1] not in state):
#             j += 1
#             answer += 1
#             state.append([i,j])
#             print("right")
#         elif maps[i-1][j] == 1 & ([i-1,j] not in state):
#             i -= 1
#             answer += 1
#             state.append([i,j])
#             print("up")
#         elif maps[i][j-1] == 1 & ([i,j-1] not in state):
#             j -= 1
#             answer += 1
#             state.append([i,j])
#             print("left")
#         else:
#             answer = -1
#             print("break")
#             break
#         print(state)
#     return answer

# 참고 사이트 : https://velog.io/@study-dev347/프로그래머스-게임-맵-최단거리