def solution(enter, leave):
#     answer = [0 for i in range(len(enter))]
#     result = []
    
#     for e in enter:
#         e_idx = enter.index(e)
#         l_idx = leave.index(e)
#         for i in range(e_idx,l_idx+1):
#             s_res = [enter[i], leave[i]]
#             s_res.sort()
#             if s_res not in result and s_res[0]!=s_res[1]:
#                 result.append(s_res)
    
#     for r in result:
#         answer[r[0]-1] += 1
#         answer[r[1]-1] += 1

    answer = [0]*len(enter)
    room = []
    e_idx = 0
    
    for l in leave:
        while l not in room:
            room.append(enter[e_idx])
            e_idx += 1
        room.remove(l)
        
        for p in room:
            answer[p-1] += 1
        answer[l-1] += len(room)
    return answer

# 참조 사이트 : https://velog.io/@deannn/Programmers-Weekly-Challenge-7주차-입실-퇴실-Python