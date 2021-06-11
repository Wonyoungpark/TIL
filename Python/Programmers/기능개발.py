import math

def solution(progresses, speeds):
    answer = []
    for p,s in zip(progresses,speeds):
        if len(answer)==0 or answer[-1][0]<-((p-100)//s):
            answer.append([-((p-100)//s),1])
        else:
            answer[-1][1] += 1
    return [q[1] for q in answer]
    
    
#     result = []
#     answer = []
#     cnt = 1
    
#     for e, p in enumerate(progresses):
#         left = 100 - p
#         res = math.ceil(left / speeds[e])
#         result.append(res)
#     for e,i in enumerate(result):
#         if i < result[e:]:
#             result.pop(e)
#             answer.append(cnt)
#             cnt = 0
#         else:
#             result.pop(e)
#             cnt += 1
    # return answer