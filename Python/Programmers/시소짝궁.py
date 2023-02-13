# from itertools import combinations, product,permutations

# def solution(weights):
#     answer = 0
#     seats = [2,3,4]
#     weight = list(set(weights))
#     for w in weight:
#         cnt=weights.count(w)
#         if cnt>1: answer += cnt*(cnt-1)/2
#         if cnt%2==0: weight.remove(w)
        
#     friends = list(combinations(weight,2))
#     seat = list(permutations(seats,2))
#     for f in friends:
#         for s in seat:
#             if s[0]*f[0] == s[1]*f[1]:
#                 answer+=1
#                 break
#     return answer

from collections import defaultdict

def solution(weights):
    answer = 0
    info = defaultdict(int)
    
    for w in weights:
        # w 무게가 같이 탈 수 있는 비율 계산
        answer += info[w] + info[w*2] + info[w/2] + info[(w*2)/3] + info[(w*3)/2] + info[(w*4)/3] + info[(w*3)/4]
        info[w] += 1
        
    return answer