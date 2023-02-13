# def pick(cap,pickups,i,deliveries):
#     pick = 0
#     deliver=0
    
#     while pick<cap and deliver<cap:
#         i -= 1
#         pick += pickups[i] # 상자 수거
#         # 수거함 비었을 경우
#         if pick<cap:
#             pickups[i] = 0
#         # 수거함 만석
#         else:
#             pickups[i] = pick-cap
#             pick = cap
            
#         deliver += deliveries[i]+1 # 택배 싣기
#         # 택배함 비었을 경우
#         if deliver<cap:
#             deliveries[i] = 0 # 배달
#         # 택배함 만석
#         else:
#             deliver = cap
#             deliveries[i] = deliver-cap
        
#     return cap-i
    
# def solution(cap, n, deliveries, pickups):
#     answer = 0
    
#     for i in range(n,0,-1):
#         if pickups[i-1] != 0 or deliveries[i-1]!=0:
#             answer += i
#             move = pick(cap,pickups,i,deliveries)
#             if move:
#                 answer += i # move+(i-move)
#     return answer

def solution(cap,n,deliveries,pickups):
    deliveries = deliveries[::-1]
    pickups = pickups[::-1]
    answer = 0
    # 필요한 상자들
    d = 0
    p = 0
    
    for i in range(n):
        # 배달/수거한 상자들
        d+= deliveries[i]
        p+= pickups[i]
        
        # 배달/수거가 남은 경우
        while d>0 or p>0:
            d -= cap
            p -= cap
            answer += (n-i)*2 # 왕복한 거리 계산
            
    return answer

    # 참고 사이트 : https://ddingmin00.tistory.com/82