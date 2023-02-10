import sys
sys.setrecursionlimit(10**5)

def solution(maps):
    
    # 2차 배열로 변경
    converted_map = [list(val) for val in maps]
    rows = len(converted_map)
    cols = len(converted_map[0])
    for r in range(rows):
        for c in range(cols):
            if converted_map[r][c] == "X":
                converted_map[r][c] = 0
            else:
                converted_map[r][c] = int(converted_map[r][c])

    # 방문한 노드, dfs 중복 방지
    seen = set()
    
    def dfs(r,c):
        # 가장 자리일 경우, 이미 방문한 노드
        if (r<0 or c<0 or (r,c) in seen or r==rows or c==cols or converted_map[r][c]==0): return 0

        # 방문한 곳
        seen.add((r,c))

        # 재귀 dfs
        return (converted_map[r][c] + dfs(r+1,c) + dfs(r-1,c) + dfs(r,c+1) + dfs(r,c-1))

    areas = []
    answer = []
    
    # 지도 확인
    for r in range(rows):
        for c in range(cols):
            areas.append(dfs(r,c))
    
    # 지낼 곳이 없는 경우
    if sum(areas) == 0: return [-1]

    # 머물 곳
    answer = [a for a in areas if a!=0]   
    answer.sort()
    
    return answer

    # 참고 사이트 : https://school.programmers.co.kr/questions/43542