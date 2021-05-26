from collections import deque

def bfs(s, visited, adj):
    cnt = 0
    q = deque([[s, cnt]])
    
    while q:
        value = q.popleft()
        s = value[0] # 시작 노드
        cnt = value[1] # 방문 횟수
        if visited[s] == -1: # 아직 방문하지 않은 노드인 경우
            visited[s] = cnt
            cnt += 1
            for e in adj[s]:
                q.append([e, cnt])
                
def solution(n, edge):
    answer = 0
    visited = [-1] * (n+1)
    adj = [[] for _ in range(n+1)] # 그래프 자리
    
    for e in edge:
        x = e[0]
        y = e[1]
        # 각 노드별 연결된 노드 정의
        adj[x].append(y)
        adj[y].append(x)
        
    bfs(1, visited, adj)
    
    for value in visited:
        if value == max(visited): # 가장 많이 방문한 노드 수 계산
            answer += 1
    
    return answer

    # 참고 사이트 : https://velog.io/@devjuun_s/가장-먼-노드-프로그래머스python