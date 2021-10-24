# 평행/일치 확인
def check(a, b, c, d):
    return (a*d) - (b*c) != 0

# 교차점 찾기
def get_xy(a, b, e, c, d, f):
    if ((b * f) - (e * d)) % ((a * d) - (b * c)) != 0 or ((e * c) - (a * f)) % ((a * d) - (b * c)) != 0:
        return (-int(10e9), -int(10e9))
    
    x = ((b * f) - (e * d)) // ((a * d) - (b * c))
    y = ((e * c) - (a * f)) // ((a * d) - (b * c))
    
    return (x, y)

def solution(line):
#     answer = []
#     interact = [] # 교차점
#     max_x = 0
#     min_x = 0
#     max_y = 0
#     min_y = 0
    
#     # 연립 방정식 생성
#     from itertools import combinations
#     com_list = list(combinations(line,2))
    
#     # 해 구하기
#     for com1, com2 in com_list:
#         xk = com1[1]*com2[2]-com1[2]*com2[1]
#         xu = com1[0]*com2[1]-com1[1]*com2[0]
#         yk = com1[2]*com2[0]-com1[0]*com2[2]
#         yu = com1[0]*com2[1]-com1[1]*com2[0]
#         if xu == 0: continue # 평행/일치할 경우
#         if xk%xu!=0 or yk%yu!=0: continue # 교차점이 실수일 경우
#         else:
#             interact.append([xk//xu, yk//yu])
#             # 판의 시작점과 끝점 구하기
#             if max_x<(xk//xu):max_x=(xk//xu)
#             if min_x>(xk//xu): min_x=(xk//xu)
#             if max_y<(yk//yu): max_y=(yk//yu)
#             if min_y>(yk//yu): min_y=(yk//yu)
#     print(interact)
    
#     # 판 생성
#     board = [["." for i in range(min_x,max_x+1)] for j in range(min_y,max_y+1)]
    
#     for x,y in interact:
#         board[abs(y+min_y)][abs(x+max_x)] = "*"
#     for b in board:
#         answer.append(''.join(b))
        
#     # 최소한의 판 크기로 조정
#     while ((answer[0].find("*")<0) or (answer[-1].find("*")<0)):
#         if answer[0].find("*")==-1: answer.pop(0)
#         if answer[-1].find("*")==-1: answer.pop()
    
    answer = []
    point_set = set()
    matrix = [['.'] * 1001 for _ in range(1001)] 
    min_x, max_x = int(10e9), -int(10e9)
    min_y, max_y = int(10e9), -int(10e9)
    
    for i in range(len(line)):
        for j in range(i):
            if check(line[i][0], line[i][1], line[j][0], line[j][1]):
                x, y = get_xy(line[i][0], line[i][1], line[i][2],
                             line[j][0], line[j][1], line[j][2])
                
                if x == -int(10e9):
                    continue
                
                if (x, y) not in point_set:
                    min_x, max_x = min(min_x, x), max(max_x, x)
                    min_y, max_y = min(min_y, y), max(max_y, y)
                    point_set.add((x, y))
    
    for x, y in point_set:
        if y - min_y <= 1000 and x - min_x <= 1000:
            matrix[y-min_y][x-min_x] = '*'
        
    max_y = max_y - min_y
    max_x = max_x - min_x
    
    for i in range(max_y, -1, -1):
        answer.append("".join(matrix[i][:max_x+1]))
        
    return answer

# 참고 사이트 : https://nbalance97.tistory.com/227, https://taehoung0102.tistory.com/entry/프로그래머스Java-Level2-교점에-별-만들기-위클리-챌린지-10주차