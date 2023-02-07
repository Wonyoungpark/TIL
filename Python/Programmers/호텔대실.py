# from datetime import datetime, timedelta

# def solution(book_time):
#     answer = 0
#     times = []
#     rooms = []
    
#     for s,e in book_time:
#         times.append([str(datetime.strptime(s,'%H:%M')),str(datetime.strptime(e,'%H:%M')+timedelta(minutes=10))])

#     times.sort()
    
#     for i,[s,e] in enumerate(times):
#         if i ==0:
#             rooms.append(e)
#             answer += 1
#         else:
#             add = True
#             for r in rooms:
#                 if r<=s:
#                     add = False
#                     break
#             if add:
#                 answer += 1
#                 rooms.append(e)
#     return answer

from heapq import heappop, heappush

def solution(book_time):
    answer = 1
    
    # 예약 시간을 분 단위 변경
    book_time_ref = [(int(s[:2])*60 + int(s[3:]), int(e[:2])*60 + int(e[3:])) for s,e in book_time]
    book_time_ref.sort()
    
    heap = []
    
    for s,e in book_time_ref:
        # 대실 이용이 없을 때
        if not heap:
            heappush(heap,e)
            continue
        # 대실 이용이 끝났을 때
        if heap[0] <= s:
            heappop(heap)
        # 대실이 만석인 경우
        else:
            answer += 1
        # 청소 시간
        heappush(heap,e+10)
    
    return answer

    # 참고 사이트 : https://velog.io/@isayaksh/알고리즘-Programmers-호텔-대실-Python