from collections import defaultdict

def solution(n, results):
    answer = 0
    
    wins = defaultdict(set)
    loses = defaultdict(set)
    
    for a,b in results:
        wins[a].add(b)
        loses[b].add(a)
        
    for i in range(1,n+1):
        for l in wins[i]:
            loses[l] |= loses[i] # 두 집합 합침
        for w in loses[i]:
            wins[w] |= wins[i] # wins[w] = wins[w] + wins[i]
            
    for i in range(1,n+1):
        if len(wins[i]) + len(loses[i]) == n-1:
            answer += 1
    
#     ranks = []
    
#     for i in range(1,n+1):
#         cnt = 0
#         for r in results:
#             if i in r:
#                 cnt += 1
#         ranks.append(cnt)
#     answer = ranks.index(4) + 1
    return answer

# 참고 사이트 : https://velog.io/@tjdud0123/순위-python