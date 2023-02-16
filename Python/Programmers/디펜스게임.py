# def solution(n, k, enemy):
#     answer = 0
    
#     # 무적권 사용
#     for i in range(k):
#         enemy.remove(max(enemy))
#         answer += 1
#     if not enemy: return answer

#     while n>enemy[0]:
#         n -= enemy[0]
#         if n<0: break
#         enemy.pop(0)
#         answer += 1
#         if not enemy: break
#     return answer

from heapq import heappop, heappush

def solution(n, k, enemy):
    answer = 0
    sumEnemy = 0
    heap = []
    
    for e in enemy:
        heappush(heap, -e) # 음수로 적 저장
        sumEnemy += e
        if sumEnemy > n:
            if k == 0: break
            sumEnemy += heappop(heap) # 적 차감
            k -= 1 # 무적권 사용
        answer += 1
        
    return answer

# 참고 사이트 : https://velog.io/@isayaksh/알고리즘-Programmers-디펜스-게임-Python