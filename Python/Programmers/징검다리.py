def solution(distance, rocks, n):
    answer = 0
    
    rocks.sort()
    rocks.append(distance)
    left,right = 0,distance
    while left<=right:
        mid = (left+right)//2
        min_distance = float('inf')
        current = 0
        remove_cnt = 0 # 제거한 바위 수
        
        for rock in rocks:
            diff = rock-current # 거리
            if diff < mid: remove_cnt += 1
            else:
                current = rock
                min_distance = min(min_distance,diff)
        if remove_cnt>n: right = mid-1
        else:
            answer = min_distance
            left = mid+1
    
    
#     rocks.sort()
    
#     from itertools import combinations
#     dlist = list(combinations(rocks,n))
    
#     for d in dlist:
#         rlist = []
#         rlist.extend(rocks)
#         rlist.remove(d[0])
#         rlist.remove(d[1])
#         rlist.append(distance)
#         rlist.insert(0,0)
        
#         betw = []
#         for r in range(len(rlist)-1):
#             betw.append(rlist[r+1]-rlist[r])
#         if answer < min(betw):
#             answer = min(betw)
        
    return answer

# 참고 사이트 : https://deok2kim.tistory.com/122