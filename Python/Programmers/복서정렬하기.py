def solution(weights, head2head):
    answer = []
    
#     leng = len(weights)
    
#     heads = []
#     for head in head2head:
#         blank = []
#         for h in head:
#             if h =="W":
#                 blank.append(1)
#             elif h =="N":
#                 blank.append(0)
#             else:
#                 blank.append(-1)
#         heads.append(blank)
    
#     # 승률
#     win_points = []
#     for h in heads:
#         win_points.append(round((h.count(1)/(leng-1)*100),2))
    
#     # 자기보다 무거운 복서를 이긴 횟수
#     heavy_points = []
#     import numpy as np
#     for e,h in enumerate(heads):
#         cnt = 0
#         if h.count(1)>=1:
#             loc = np.where(np.array(h) == 1)[0].tolist()
#             for l in loc:
#                 if weights[e] < weights[l]:
#                     cnt += 1
#         heavy_points.append(cnt)
        
#     weight = weights.copy()
#     idx = [i+1 for i in range(leng)]
    
#     # 정렬
#     result = list(zip(idx, win_points, heavy_points, weight))
#     result = sorted(result, key=lambda x: (-x[1], -x[2], -x[3], x[0]))
#     answer = [r[0] for r in result]


    match_result_list = []
    for person_idx, results in enumerate(head2head):
        my_weight = weights[person_idx]
        win_num, win_goliath, match_num =0, 0, 0
        for result_idx, result in enumerate(results):
            if result != "N":
                match_num += 1
            if result == "W":
                win_num += 1
                if weights[result_idx] > my_weight:
                    win_goliath += 1
        win_percent = win_num / match_num * 100 if match_num != 0 else 0
        match_result_list.append((person_idx + 1, win_percent, win_goliath, my_weight))
    match_result_list = sorted(match_result_list, key=lambda x: (-x[1], -x[2], -x[3], x[0]))
    answer = [result[0] for result in match_result_list]
    return answer

# 참고 사이트 : https://somjang.tistory.com/entry/Programmers-위클리-챌린지-6주차-복서-정렬하기-Python