import sys

def solution():
    input = sys.stdin.readline().split()
    n,m = map(int,input) # 세로, 가로
    result = 0

    ## 4번 미만으로 움직일 경우
    if n == 1: result = 1 # 세로 1칸일 경우, 이동 불가
    # 세로 2칸일 경우, 위아래 이동 가능 # 방문 칸 = result+1
    elif n == 2: result = min(4, (m-1)//2+1)
    # 세로 3칸 이상 & 가로 6칸 이하, 최대 이동회수(3)만큼 제한
    elif m <= 6: result = min(4, m)
    ## 4번 이상 움직일 경우, 4가지 방법 모두 사용
    else: result = (2+(m-5)) + 1

    return result

print(solution())