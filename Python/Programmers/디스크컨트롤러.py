import heapq

def solution(jobs):
    answer, now, i = 0, 0, 0
    start = -1
    heap = []
    
    while (i<len(jobs)):
        # 작업 소요 시간 기준 정렬
        for j in jobs:
            if start < j[0] <= now:
                heapq.heappush(heap, [j[1],j[0]])
        if len(heap) > 0:
            current = heapq.heappop(heap)
            start = now
            now += current[0]
            answer += now-current[1]
            i += 1
        else: # 작업을 수행하지 않을 경우
            now += 1
    return int(answer/len(jobs))


# def solution(jobs):
#     answer = 0
#     sortjob = sorted(jobs, key = lambda x : x[1])
#     last = 0
    
#     for i in sortjob:
#         last += i[1]
#         answer += last - i[0]
#     return answer / len(sortjob)

# 참고 사이트 : https://velog.io/@younge/Python-프로그래머스-디스크-컨트롤러-힙