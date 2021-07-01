from queue import PriorityQueue

def solution(N, road, K):
    answer = 0

    q = PriorityQueue() # 선입선출
    q.put([1,0]) # 시작점
    dist = [float('inf')]*(N+1)
    dist[1] = 0
    
    while not q.empty():
        current, c_cost = q.get()
        for star, dest, cost in road:
            next_cost = cost + c_cost
            if star == current and next_cost < dist[dest]:
                dist[dest] = next_cost
                q.put([dest, next_cost])
            if dest == current and next_cost < dist[star]:
                dist[star] = next_cost
                q.put([star, next_cost])
                
    answer = len([i for i in dist if i<= K])
    return answer

# 참고 사이트 : https://velog.io/@rapsby/프로그래머스-배달-python